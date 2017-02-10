//
// Created by hadoop on 16-10-23.
/**
 * 说明：

　　（1）&在此不是求地址运算，而是起标识作用。

　　（2）类型标识符是指目标变量的类型。

　　（3）声明引用时，必须同时对其进行初始化。

　　（4）引用声明完毕后，相当于目标变量名有两个名称，即该目标原名称和引用名，且不能再把该引用名作为其他变量名的别名。

　　 ra=1; 等价于 a=1;

　　（5）声明一个引用，不是新定义了一个变量，它只表示该引用名是目标变量名的一个别名，它本身不是一种数据类型，因此引用本身不占存储单元，系统也不给引用分配存储单元。故：对引用求地址，就是对目标变量求地址。&ra与&a相等。

　　（6）不能建立数组的引用。因为数组是一个由若干个元素所组成的集合，所以无法建立一个数组的别名。
 * */

//
#include <iostream>
using namespace std;
int set_postion(int);
typedef struct system{
    void out(int maze[9][9]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                cout<<maze[i][j]<<" ";
            };
            cout<<" "<<endl;
        };
    }
}* news;
int set(int set_postion){
    if(set_postion==0){set_postion=4;}
    else set_postion++;
    return set_postion;
}
int Condition(int maze[9][9],int i,int j,int set_postion){
    int num=0;
    //判断分支条件 >=2 表示有多条未走或没有堵死（5）的支路，有多支路，则反0，下一个位置不置位，保持4
    if(maze[i][j+1]<5&&maze[i][j+1]!=1&&maze[i][j]==4)num++;//下个位置的四个方向中存在小于标准直且不是1的个数
    if(maze[i+1][j]<5&&maze[i][j+1]!=1&&maze[i][j]==4)num++;//maze[i][j]==4原数为2则不计数
    if(maze[i][j-1]<5&&maze[i][j+1]!=1&&maze[i][j]==4)num++;
    if(maze[i-1][j]<5&&maze[i][j+1]!=1&&maze[i][j]==4)num++;
    if (num>=2){
        return 0;//不满足置为条件
    }
    return 1;
}
int quit(int maze[9][9],int i,int j){//接收当前位置。判断4

    if (maze[i+1][j]==3) {
        return 1;}//退出迷宫
    if (maze[i][j+1]==3)return 1;//退出迷宫
    if (maze[i-1][j]==3)return 1;//退出迷宫
    if (maze[i][j-1]==3)return 1;//退出迷宫
    return 0;
}
void run(int maze[9][9]){
    int i=0;
    int j=2;
    int set_postion =0;
    int change_postion =4;
    news System;
    int atomic =0;
    while (1){
//        cout<<"第"<<++atomic<<"步"<<endl;
//        System->out(maze);
//        if(atomic==42)break;
        if(maze[i+1][j]==set_postion){
                change_postion=set(set_postion);
                if(change_postion!=4){
                    maze[i][j]=change_postion;
                }
                int condition =Condition(maze,i+1,j,set_postion);
                if(condition){//满足置位条件则下一个位置置位 //5或4 //用于出现回退时分支是否填5
                    maze[i+1][j]=change_postion;
                }

            i++;//置数成功，指针移动
            set_postion=0;

            if(quit(maze,i,j))break;
            continue;}//↓
        else   if(maze[i][j+1]==set_postion){
                change_postion=set(set_postion);
                if(change_postion!=4){//不是四，说明不是第一次走，则当前位置位，下一为判断
                    maze[i][j]=change_postion;
                }
                int condition =Condition(maze,i,j+1,set_postion);
                if(condition){//满足置位条件则下一个位置置位 //5或4 //用于出现回退时分支点是否填5
                    maze[i][j+1]=change_postion;
                }

            j++;set_postion=0;

            if(quit(maze,i,j))break;
            continue;}//→
        else  if(maze[i-1][j]==set_postion){
                change_postion=set(set_postion);
                if(change_postion!=4){
                    maze[i][j]=change_postion;
                }
                int condition =Condition(maze,i-1,j,set_postion);
                if(condition){//满足置位条件则下一个位置置位 //5 //用于出现回退时分支是否填5
                    maze[i-1][j]=change_postion;
                }

            i--;set_postion=0;
            if(quit(maze,i,j))break;
            continue;}//↑
        else  if(maze[i][j-1]==set_postion){
                change_postion=set(set_postion);
                if(change_postion!=4){
                    maze[i][j]=change_postion;
                }
                int condition =Condition(maze,i,j-1,set_postion);
                if(condition){//满足置位条件则下一个位置置位 //5 //用于出现回退时分支是否填5
                    maze[i][j-1]=change_postion;
                }

            j--;set_postion=0;
            if(quit(maze,i,j))break;
            continue;}//←

        else set_postion=4;
    }


    System->out(maze);

}
int test(){
    news System;
    int maze3[9][9]={{1,1,2,1,1,1,1,1,1},
                     {1,0,0,0,0,0,0,0,1},
                     {1,0,1,1,1,0,1,1,1},
                     {1,0,1,0,0,4,0,0,1},
                     {1,0,1,0,1,0,1,0,1},
                     {1,0,1,0,0,0,0,0,1},
                     {1,0,1,1,1,1,1,1,1},
                     {1,0,0,1,1,0,0,0,1},
                     {1,0,3,1,1,1,1,1,1}};

    int maze2[9][9]={{1,1,2,1,1,1,1,1,1},
                     {1,0,0,0,0,0,0,0,1},
                     {1,0,1,1,1,0,1,1,1},
                     {1,0,1,0,0,0,0,0,1},
                     {1,0,1,0,1,0,1,0,1},
                     {1,0,1,0,0,0,0,0,1},
                     {1,0,1,1,1,1,1,1,1},
                     {1,0,0,1,1,0,0,0,1},
                     {1,0,3,1,1,1,1,1,1}
    };
    int maze1[9][9]={{1,2,1,1,1,1,1,1,1},
                    {1,0,0,0,0,0,0,1,1},
                    {1,1,1,1,1,0,1,1,1},
                    {1,0,0,0,0,0,0,1,1},
                    {1,1,0,1,1,1,0,0,3},
                    {1,0,0,0,0,0,0,1,1},
                    {1,0,1,1,1,0,1,1,1},
                    {1,0,1,1,0,0,0,1,1},
                    {1,1,1,1,1,1,1,1,1}
    };
    int maze[9][9]={{1,2,1,1,1,1,1,1,1},
                    {1,0,0,0,0,0,0,1,1},
                    {1,1,1,1,1,0,1,1,1},
                    {1,0,0,0,0,0,0,1,1},
                    {1,0,1,1,1,1,0,1,1},
                    {1,0,0,0,0,0,0,1,1},
                    {1,0,1,1,1,0,1,1,1},
                    {1,0,1,1,0,0,0,1,1},
                    {1,3,1,1,1,1,1,1,1}
    };
    System->out(maze2);
    cout<<" "<<endl;
    run(maze2);
//    cout<<maze[0][1]<<endl;//x行 y列
}

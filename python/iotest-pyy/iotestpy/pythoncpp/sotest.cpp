//g++ -shared -fpermissive -fPIC sotest.cpp -o sotest.so

#include <iostream>
#include<stdlib.h>
#include<string.h>
using namespace std;
extern "C"{
    char* display(char* msg){
        cout<<msg<<endl;
        int len=strlen(msg)+8;
        cout<<len<<endl;
        char *res=(char *)malloc(len);
        memset(res,0,len);
        strcat(res,"hello ");
        strcat(res,msg);
        strcat(res,"!");
        cout<<res<<endl;
        return res;
    }

    int add(int a,int b){
        return a+b;
    }
}

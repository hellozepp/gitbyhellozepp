package org.SimapleDemo.classInfo;

/**课的人员名单：\"小明\",\"小吴\",\"
 * Created by hadoop on 16-7-29.
 */

    public class ChooseCon{
    static int selectCno[][] ={ {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    public void chooseCon(){
        System.out.println("需选课的人员名单：\"小明\",\"小吴\",\"小黄\",\"小刘\"");
        Student student =new Student();
        for(int sno=0 ;sno<4;sno++){
            System.out.println("分配"+student.stu[sno]+"课程");
            System.out.println("0.语文，1.英语，2.数学，3.物理");
            int con =Test.input();
            selectCno[sno][con]+=1;
            System.out.println("选课成功！");
        }
    }
    public void Ccount(){
        int ccount=0;
        Student student =new Student();
        for(int sno=0;sno<4;sno++)
            for(int cno=0;cno<4;cno++) {
            ccount+=selectCno[sno][cno];
            if(cno==3){
                System.out.println("一个学生被多少老师教显示结果如下：");
                System.out.println(student.stu[sno]+":"+ccount);
                ccount=0;
            }
        }
    }
    static int countAllNo;
    public void Tcount(){
        int tcount=0;
        int countAll=0;
        Teacher teacher =new Teacher();
        for(int cno=0;cno<4;cno++)
            for(int sno=0;sno<4;sno++) {
                tcount +=selectCno[sno][cno];
                if(sno==3){
                    System.out.println("一个教师教多少学生结果如下：");
                    System.out.println(teacher.tea[cno]+":"+tcount);
                    if(countAll<tcount){
                        countAllNo=cno;
                    }
                        tcount=0;
                }
            }

    }
    public void countAll(){
        Teacher teacher =new Teacher();
        System.out.println("最受欢迎的课程为："+teacher.tea[countAllNo]);
    }
}


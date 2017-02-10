package org.SimapleDemo.classInfo;

import java.util.Scanner;

/**
 * Created by hadoop on 16-7-29.
 */
public  class Test {
    public static void main(String[] args) {
        while (true){
            System.out.println("选择如下选项：\n1.选课\n2.教师授课人数\n3.学生选修教师数量\n4.最受欢迎的课程\n");

            switch (input()){
                case 1:{new ChooseCon().chooseCon();}break;
                case 2:{new ChooseCon().Tcount();}break;
                case 3:{new ChooseCon().Ccount();}break;
                case 4:{new ChooseCon().countAll();}break;
            }
        }
    }
    static int input() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        return a;
    }

    }



package taylor;

public class Test3 {
    //函数能泰勒展开的必要条件是在展开点附近任意阶可导，充分条件是余项能趋于零。
    private static double pi=3.141592658;
    //定义一个求绝对值的方法
    double myabs(double n){
        if(n<0){
            n*=(-1);
        }
        return n;
    }
    //求sin
    double mysin(double x){
        int i=1,sign=1;
        double item=x,frac=0,fz=x,fm=1;
        for(;myabs(item)>=10E-8;i+=2){
            frac+=item;//累加
            fz=fz*x*x;//分子
            fm=fm*(i+1)*(i+2);//分母
            sign=-sign;//符号
            item=sign*(fz/fm);//临时变量
        }
        return (frac);    
    }
    //求cos
    double mycos(double x){
        int i=0,sign=1;
        double item=1,frac=0,fz=1,fm=1;
        for(;myabs(item)>=10E-8;i+=2){
            frac+=item;
            fz=fz*x*x;
            fm=fm*(i+1)*(i+2);
            sign=-sign;
            item=sign*(fz/fm);
        }
        return (frac);
    }
    public static void main(String[] args){
        Test3 test3 = new Test3();
//        System.out.println(test3.mysin(0.25*pi));
//        System.out.println(test3.mysin(1));
        System.out.println(test3.mycos(1));//0.540302303791887
    }

}
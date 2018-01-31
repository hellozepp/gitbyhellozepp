package taylor;

import java.util.Scanner;
 
public class Test {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double x = 1;
//        Scanner in = new Scanner(System.in);
//        System.out.print("请输入x:");
//        x = in.nextDouble();
        System.out.println("sin("+x+") = "+calcsin(x));
    } 
     
    static double calcsin(double x) {
        double result = 0;
        int temp = 0;
        while((Math.pow(x,2*temp+1)/jiecheng(2*temp+1)) > 1.0E-8) {
            result += (Math.pow(x,2*temp+1)/jiecheng(2*temp+1))*Math.pow(-1, temp);
            temp ++;
          System.out.print("第"+temp+"次迭代！" );
          System.out.println(result);
        }
        return result;
    }
     
    static int jiecheng(int x) {
        int plus=1;
        for(int i=1;i<=x;i++){
            plus*=i;
        }
        return plus;
    }
 
}
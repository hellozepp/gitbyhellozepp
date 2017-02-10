package org;

/**
 * Created by hadoop on 16-8-2.
 */
class   MyException extends Exception{
   public MyException(String xxx){
       super(xxx);
   }
}
class Opt{
    public int div(int i,int j) throws MyException{
            if(j==0){throw new MyException("aaaaaaa");}
            int d=i/j;
        return d;
}
}
public class ExceptionTest  {
    //自定义异常

    public static void main(String[] args) {
        int a =1;
        int b =0;
        int c =1;
        Opt opt = new Opt();

        try {
            c=opt.div(a,b);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
//            System.out.println(a/b);
            System.out.println("aaa");
        }
        catch (Exception e){
            System.out.println("b不能为零");
            e.printStackTrace();
        }finally{
            System.out.println("ccc");
        }

    }


}

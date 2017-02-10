package org.File.org;

/**
 * Created by hadoop on 16-8-2.
 */
public class StaticCode {
    public static void main(String[] args) {

//        System.out.println(TestStatic.str);
        TestStatic ts =  new TestStatic();
        ts.aaa();
    }
}
class TestStatic{
    {
        System.out.println("gouzao");
    }
    static {
        int a =1;
        str="222";
        System.out.println("1111111");
    }
    public TestStatic(){
        System.out.println("3333333");
    }
    void aaa(){
        System.out.println("aaaa");
    }
    public static String str="1111";

}
class ccc{
    private int myint;
    public ccc(int myint){
        this.myint=myint;
        System.out.println("ccc"+myint);
    }
    int a =2;
    static
    String str ="aaaa";
    public void bbb(){
        int bbb =1;    }
}
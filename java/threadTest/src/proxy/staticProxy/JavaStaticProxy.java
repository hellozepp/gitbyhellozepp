package proxy.staticProxy;

/**
 * Created by hadoop on 2017/1/21.
 * 继承clazz接口来代理其中的方法，让用户感觉用的还是一个类
 */
public class JavaStaticProxy implements Clazz{
    private  Clazz clazz;

    public JavaStaticProxy(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public void option1() {
        System.out.println("operate this method first...");
        clazz.option1();
        System.out.println("operate this method end...");
    }
}

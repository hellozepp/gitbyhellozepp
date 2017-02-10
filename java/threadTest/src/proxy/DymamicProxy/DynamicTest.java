package proxy.DymamicProxy;

import org.junit.Test;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by hadoop on 2017/1/21.
 */
public class DynamicTest {
    public static void main(String[] args) {
        Clazz clazz =new ClazzImpl();
        InvocationHandler invocationHandler =new Invocation(clazz);
        Clazz subject = (Clazz) Proxy.newProxyInstance(clazz.getClass().
                getClassLoader(),clazz.getClass().getInterfaces(),invocationHandler);
        subject.option1();

    }
    @Test
    public void test(){
        Clazz clazz =new ClazzImpl();
        InvocationHandler invocationHandler =new Invocation(clazz);
        Clazz subject = (Clazz) Proxy.newProxyInstance(clazz.getClass().
                getClassLoader(),clazz.getClass().getInterfaces(),invocationHandler);
        subject.option1();
    }
}

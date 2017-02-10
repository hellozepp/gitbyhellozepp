package proxy.DymamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hadoop on 2017/1/21.
 */
public class Invocation implements InvocationHandler {
    private Object proxy;
    Invocation(){};
     Invocation(Object obj){
        this.proxy=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前处理"+method);
        Object object =method.invoke(this.proxy,args);
        System.out.println("后处理"+method);
        return object;
    }
}
/**
 *
 import java.lang.reflect.Method;
 import java.lang.reflect.InvocationHandler;

 public  class DynamicSubject implements InvocationHandler {
 private Object sub;
 public DynamicSubject() {}

 public DynamicSubject(Object obj) {
 sub = obj;
 }

 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
 System.out.println( " before calling "  + method);
 method.invoke(sub,args);

 System.out.println( " after calling "  + method);
 return  null ;
 }
 }
 */
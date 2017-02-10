package org1.Reflect.myProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hadoop on 16-10-13.
 */
public class MyInvocationHandler implements InvocationHandler {
    public void setTarget(DogImpl target) {
        this.target = target;
    }
    private DogImpl target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Util111 util111 =new Util111();
        util111.method1();
        Object result =method.invoke(target,args);
        util111.method2();
        return result;
    }
}

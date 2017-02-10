package org1.Reflect.myProxy;

import java.lang.reflect.Proxy;

/**
 * Created by hadoop on 16-10-13.
 */
public class MyProxyFactory {
    public static Object getProxy(DogImpl target) {
        MyInvocationHandler handler =new MyInvocationHandler();
        handler.setTarget(target);
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader()
                ,target.getClass().getInterfaces(),handler);
        return proxy;
    }
}

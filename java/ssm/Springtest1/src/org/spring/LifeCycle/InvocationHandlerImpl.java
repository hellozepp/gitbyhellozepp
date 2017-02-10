package org.spring.LifeCycle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hadoop on 16-9-9.
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private  Object o =null;
    public InvocationHandlerImpl(Object o) {
        this.o = o;
        System.out.println(" 实例化     o  "+o);
    }
    @Override
        public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
            System.out.println("执行invoke2");
            if ("eat".equals(method.getName())){
                System.out.println("饭 ——1");
                Object result = method.invoke(this.o,objects);
                return result;
    }
        return  proxy;
        }
    }


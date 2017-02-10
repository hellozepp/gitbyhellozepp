package org.spring.normal.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by LeoAshin on 16/9/3.
 * in 下午9:56
 */
class ArithmeticCalculatorInvocationHandler implements InvocationHandler {

    private Object target = null;

    ArithmeticCalculatorInvocationHandler(Object target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("the method ["+method.getName()+"]"+"begin with args ("+ Arrays.toString(args)+")");

        Object result = method.invoke(this.target, args);

        System.out.println("the method ["+method.getName()+"]"+"end with result ("+result+")");

        return result;
    }

    Object getProxy(){
//        return Proxy.getProxyClass(this.target.getClass().getClassLoader(), this.getClass().getInterfaces());
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(), this);
    }
}

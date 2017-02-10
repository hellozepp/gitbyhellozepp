package org.spring.LifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hadoop on 16-9-8.
 */
public class MyBeanPostProcess implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {//增强操作
        System.out.println("5 初始化之前");
        return o;
    }
    @Override
    public Object postProcessAfterInitialization(final Object o, String s) throws BeansException {//
        System.out.println("8 初始化类之后    "+o.getClass().getName()+"   "+ s);
        if (s.equals("bean4")){//动态代理
            System.out.println("执行invoke1");
            InvocationHandler invocationHandler =new InvocationHandlerImpl(o);
           Animal2Impl result=(Animal2Impl)Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), invocationHandler);
            return result;
        }
        else System.out.println("执行111");
        return o;
    }
}

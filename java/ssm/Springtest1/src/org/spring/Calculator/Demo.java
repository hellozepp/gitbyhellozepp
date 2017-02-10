package org.spring.Calculator;

import java.lang.reflect.Proxy;

/**
 * Created by hadoop on 16-9-4.
 */
public class Demo {
    public static void main(String[] args) {
        Calculator acl =new ArithmeticCalculator();
        ArithmeticCalculatorInvocationHandler ari =new ArithmeticCalculatorInvocationHandler(acl);
        //（ArithmeticCalculatorInvocationHandler实现Invocationhandler方法重写invoke方法）
        //动态代理 处理要增强的内容
        Calculator calculator = (Calculator) Proxy.newProxyInstance(
                acl.getClass().getClassLoader(), acl.getClass().getInterfaces(),ari);
        calculator.add(1.0,1.0);
    }
}

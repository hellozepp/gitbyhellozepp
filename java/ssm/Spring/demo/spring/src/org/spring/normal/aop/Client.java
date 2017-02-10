package org.spring.normal.aop;

/**
 * Created by LeoAshin on 16/9/3.
 * in 下午10:01
 */
public class Client {

    public static void main(String[] args) throws Exception {

        Calculator calculator = (Calculator) new ArithmeticCalculatorInvocationHandler(new ArithmeticCalculator()).getProxy();
        calculator.add(1,2);
    }
}

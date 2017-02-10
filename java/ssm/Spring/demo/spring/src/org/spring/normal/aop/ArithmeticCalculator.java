package org.spring.normal.aop;

/**
 * Created by LeoAshin on 16/9/3.
 * in 下午9:50
 */
class ArithmeticCalculator implements Calculator {
    public double add(double num1, double num2) throws Exception {
        double result = num1 + num2;
        return result;
    }

    public double sub(double num1, double num2) throws Exception {
        double result = num1 - num2;
        return result;
    }

    public double div(double num1, double num2) throws Exception {
        double result = num1 / num2;
        return result;
    }

    public double mul(double num1, double num2) throws Exception {
        double result = num1 - num2;
        return result;
    }
}

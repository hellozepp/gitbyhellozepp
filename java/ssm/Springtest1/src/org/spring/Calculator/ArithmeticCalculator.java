package org.spring.Calculator;

/**
 * Created by hadoop on 16-9-4.
 */
public class ArithmeticCalculator implements Calculator {
    @Override
    public double add(double num1, double num2) {
        return num1+num2;
    }

    @Override
    public double mun(double num1, double num2) {
        return num1-num2;
    }

    @Override
    public double multi(double num1, double num2) {
        return num1*num2;
    }

    @Override
    public double sub(double num1, double num2) {
        return num1/num2;
    }
}

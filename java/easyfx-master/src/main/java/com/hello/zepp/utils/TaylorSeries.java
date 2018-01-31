package com.hello.zepp.utils;

import java.math.*;
/**
 * This class implements a new Taylor Series to calculate accurate values for mathematical
 * equations.
 * @author Nathan Solomon
 * @version 1.0 -- Last Updated 5/29/2017
 *
 *
 */
public class TaylorSeries {
	
	private BigDecimal accuracy = new BigDecimal("0");
	private double center;
	private BigDecimal lastApproximation = new BigDecimal("0");
	private BigDecimal approximation = new BigDecimal("0");
	private int steps;
	
	/**
	 * This constructs a McLauren Series (Taylor Series with a center of 0) with an accuracy
	 * of 4 decimal places.
	 */
	public TaylorSeries(){
		this.center = 0;
		this.accuracy = BigDecimal.valueOf(.0001);
		this.steps = 0;
	}
	
	/**
	 * This constructs a McLauren Series (Taylor Series with a center of 0) with a given accuracy 
	 * as a double. 
	 * @param accuracy
	 */
	public TaylorSeries(double accuracy){
		this.center = 0;
		this.accuracy = BigDecimal.valueOf(accuracy);
		this.steps = 0;
	}
	
	/**
	 * This constructs a Taylor Series with a given center and number of decimal places we want all 
	 * calculations to be accurate to. This will not run if accuracy is less than 0. Please input accuracy
	 * as a double value if you want a different accuracy level.
	 * @param center The center of the Taylor Series. Must be greater than 0.
	 * @param accuracy The chosen accuracy of the Taylor Series given as a number of decimal places.
	 */
	public TaylorSeries(double center, int accuracy) throws Exception{
		this.center = center;
		this.steps = 0;
		
		setAccuracy(accuracy);
		
	}
	
	/**
	 * This constructs a Taylor Series with a given center and accuracy (as a decimal).
	 * @param center The center of the Taylor Series.
	 * @param accuracy The chosen accuracy of the Taylor Series given as a decimal.
	 */
	public TaylorSeries(double center, double accuracy){
		this.center = center;
		this.accuracy = BigDecimal.valueOf(accuracy);
		this.steps = 0;
	}
	
	/**
	 * This method tests to see if we have reached the right level of accuracy
	 * @return A boolean to show if the right level of accuracy has been reached or not
	 */
	public boolean isAccurate(){
		/*
		if(this.accuracy > 0 && 
				(this.approximation-this.lastApproximation) < this.accuracy &&
				(this.approximation-this.lastApproximation) > -this.accuracy){
			return true;
		}
		else{
			return false;
		}
		*/
		
		BigDecimal difference = this.approximation.subtract(this.lastApproximation).divide(this.accuracy);
		if(difference.compareTo(BigDecimal.valueOf(1)) > 0 || difference.compareTo(BigDecimal.valueOf(-1)) < 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * This method will return an approximation of 1/(1-x).
	 * @param x The value of x in 1/(1-x)
	 */
	public void geometricSeriesApproximation(double x){
		//set the initial condition
		if(this.steps == 0){
			this.steps = 1;
			this.lastApproximation = BigDecimal.valueOf(0);
		}
		else{
			this.lastApproximation = this.approximation;
		}
		
		//create the next addition
		BigDecimal nextApproximation = BigDecimal.valueOf(x);
		
		
		//find the next addition
		nextApproximation = nextApproximation.pow(this.steps-1);
		
		//add next addition
		this.approximation = this.lastApproximation.add(nextApproximation);
		this.steps++;
		
		//test accuracy and either return or continue with other method
		if(!isAccurate()){
			geometricSeriesApproximation(x);
		}
		else{
			return;
		}
		
	}
	public double eSeriesApproximation(double exponent) {
		double result = 0;
		double calc =1;
		for(int limit = 0; calc >=10E-8; limit++) {
			calc = ((Math.pow(exponent, limit)) / this.factorial(limit));
			result += calc;
		}
		return result;
	}

//	public void eSeriesApproximation(double x){
//		//set initial condition
//		if (this.steps == 0){
//			this.steps = 1;
//			this.lastApproximation = BigDecimal.valueOf(0);
//		}
//		else{
//			this.lastApproximation = this.approximation;
//		}
//
//		//create the next addition
//		BigDecimal nextApproximation = BigDecimal.valueOf(x);
//
//		//find next addition
//		BigDecimal dividend = nextApproximation.pow(this.steps-1);
//		BigDecimal divisor = BigDecimal.valueOf(TaylorSeries.factorial(this.steps-1));
//		nextApproximation = dividend.divide(divisor);
//
//		//add next addition
//		this.approximation = this.lastApproximation.add(nextApproximation);
//		this.steps++;
//
//		//test accuracy and either return or continue with other method
//		if(!isAccurate()){
//			eSeriesApproximation(x);
//		}
//		else{
//			return;
//		}
//
//	}
	
	/**
	 * Calculates the factorial of an integer. Increments from 1, multiplying by each integer until it
	 * reaches the input number
	 * @param factorial The number we want to find the factorial of
	 * @return The factorial of the number.
	 */
	public static int factorial(int factorial){
		int answer = 1;
		for(int i = 1; i <= factorial; i++){
			answer = answer * i;
		}
		return answer;
	}
	
	
	/**
	 * Setter method for steps
	 * @param steps The number of steps to reach desired accuracy
	 */
	public void setStep(int steps){
		this.steps = steps;
	}
	
	/**Setter method for accuracy
	 * @param accuracy The chosen accuracy of the Taylor Series given as a number of decimal places.
	 */
	public void setAccuracy(double accuracy){
		this.accuracy = BigDecimal.valueOf(accuracy);
	}
	
	public void setAccuracy(int accuracy){
		//Following Algorithm converts int accuracy to a double accuracy.
		if(accuracy > 0){
			this.accuracy = BigDecimal.valueOf(.1);
			for(int i = 0; i < accuracy-1; i++){
				this.accuracy = this.accuracy.multiply(BigDecimal.valueOf(.1));
			}
		}
		else if(accuracy < 0){
			this.accuracy = BigDecimal.valueOf(10);
			for(int i = 0; i < accuracy-1; i++){
				this.accuracy = this.accuracy.multiply(BigDecimal.valueOf(10));
			}
		}
		else{
			this.accuracy = BigDecimal.valueOf(1);
		}
	}
	
	/**Setter method for the center of Taylor Series
	 * @param center The center of the Taylor Series. Must be greater than 0.
	 */
	public void setCenter(double center){
		this.center = center;
	}
	
	/**Setter method for the approximation of the value
	 * @param approximation
	 */
	public void setApproximation(double approximation){
		this.approximation = BigDecimal.valueOf(approximation);
	}
	
	/**
	 * Getter method for steps
	 * @return The number of steps to reach desired accuracy
	 */
	public int getStep(){
		return this.steps;
	}
	
	/**
	 * Getter method for accuracy
	 * @return The Accuracy level (as a decimal)
	 */
	public double getAccuracy(){
		return this.accuracy.doubleValue();
	}
	
	/**
	 * Getter method for the center of Taylor Series
	 * @return The center of the Taylor Series
	 */
	public double getCenter(){
		return this.center;
	}
	
	/**
	 * Getter method for the approximation of the value
	 * @return 
	 */
	public double getApproximationDouble(){
		return this.approximation.doubleValue();
	}
	
	/**
	 * getter method for the approximation that returns as a big decimal
	 * @return
	 */
	public BigDecimal getApproximationBigDecimal(){
		return this.approximation;
	}
	
	/**
	 * This method will reset the Taylor Polynomial. It sets all approximations
	 * to 0 and the step counter to 0.
	 */
	public void reset(){
		this.steps = 0;
		this.approximation = BigDecimal.valueOf(0);
		this.lastApproximation = BigDecimal.valueOf(0);
	}
	//定义一个求绝对值的方法
	public double myabs(double n){
		if(n<0){
			n*=(-1);
		}
		return n;
	}
	//求sin
	public double sin(double x){
		int i=1,sign=1;
		double item=x,frac=0,fz=x,fm=1;
		for(;myabs(item)>=10E-8;i+=2){
			frac+=item;//累加
			fz=fz*x*x;//分子
			fm=fm*(i+1)*(i+2);//分母
			sign=-sign;//符号
			item=sign*(fz/fm);//临时变量
		}
		return (frac);
	}
	//求cos
	public double cos(double x){
		int i=0,sign=1;
		double item=1,frac=0,fz=1,fm=1;
		for(;myabs(item)>=10E-8;i+=2){
			frac+=item;
			fz=fz*x*x;
			fm=fm*(i+1)*(i+2);
			sign=-sign;
			item=sign*(fz/fm);
		}
		return (frac);
	}
	
}

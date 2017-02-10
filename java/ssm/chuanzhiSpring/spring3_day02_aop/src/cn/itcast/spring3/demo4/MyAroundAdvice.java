package cn.itcast.spring3.demo4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 增强的类:
 * 使用的是环绕增强
 * @author 姜涛
 *
 */
public class MyAroundAdvice implements MethodInterceptor{
	
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("环绕前增强...");
		Object result = methodInvocation.proceed();// 执行目标对象的方法
		System.out.println("环绕后增强...");
		return result;
	}

}

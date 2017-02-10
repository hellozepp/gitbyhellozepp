package org.aop.aop;

import org.aspectj.lang.JoinPoint;

/**
 * Created by andilyliao on 17-1-4.
 */
public class AopBean {
    //前置通知方法
    public void mybefore(){
        System. out .println("--前置通知--");
    }
    //后置通知方法
    public void myafterReturning(Object retVal){
        System. out .println("--后置通知--" + retVal);
    }
    //异常通知方法
    public void myafterException(Exception ex){
        System. out .println("--异常通知begin--");
        System.out.println(ex);
        System. out .println("--异常通知end--");
    }
    //最终通知
    public void myafter(){
        System. out .println("--最终通知--");
    }
}

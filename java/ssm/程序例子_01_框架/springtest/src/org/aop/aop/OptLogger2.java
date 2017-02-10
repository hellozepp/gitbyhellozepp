package org.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by andilyliao on 17-1-4.
 */
@Component("optLogger2")
@Aspect
public class OptLogger2 {
    @Pointcut("within(org.aop.service1..*)")
    public void servicePointcut(){}
    //环绕通知处理
    @Before("servicePointcut()")
    public void logger(){
        System. out .println("记录操作日志了...");
    }
}

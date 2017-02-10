package org.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by andilyliao on 17-1-4.
 */
public class OptLogger1 {
    public Object logger(ProceedingJoinPoint pjp) throws Throwable{
//proceed()方法有执行目标对象的功能
        Object obj = pjp.proceed();
//获取方法名
        String method =
                pjp.getSignature().getName();
//获取目标对象类名
        String clazzName =
                pjp.getTarget().getClass().getName();
        System. out .println(
                "执行了" + clazzName + "的" + method + "方法");
        return obj;
    }
}

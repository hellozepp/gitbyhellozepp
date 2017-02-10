package org.spring.Calculator;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import java.util.Arrays;

/**
 * Created by hadoop on 16-9-4.
 */
class ArithmeticCalculatorInvocationHandler implements InvocationHandler {//继承处理器 只要外界调用 就会处理invoke
    private Object target =null;
    public ArithmeticCalculatorInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("sub".equals(method.getName() )){
            if ((Double)args[1] == 0) throw new Exception("分母不能为0");
           }
        System.out.println("the method="+method.getName()+" the  args="+ Arrays.toString(args));
        Object result =method.invoke(this.target,args);
        System.out.println("method   "+method.getName()+"  result= "+result);
        return  result;
    }

}

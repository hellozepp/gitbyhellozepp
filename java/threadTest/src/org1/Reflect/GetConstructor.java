package org1.Reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hadoop on 16-8-16.
 */
public class GetConstructor {
    public static void main(String[] args) throws Exception {
//      构造器
      String getName ="org1.Reflect.Test";
        Class clazz =org1.Reflect.Test.class;
        Class clazz1 =Class.forName(getName);
//      System.out.println(clazz.getMethods());
        Constructor cons =clazz.getConstructor(String.class,int.class);
        Object obj=cons.newInstance("xiaoming",12);
//        System.out.println(obj);
      System.out.println("-----------------------------------");
//      私有字段
        String fieldName="age";
        Field field =clazz.getDeclaredField(fieldName);
        Object obj1=clazz.newInstance();//clazz.age
        field.setAccessible(true);
        field.set(obj1,23);//age=23;
        System.out.println("第二步"+obj1);

        //方法
      System.out.println("-----------------------------------");
        String className2 = "org1.Reflect.Test";
        Class clazz2 = Class.forName(className2);
        String methodName2 = "show";
        //拿到方法 需要 方法名 和 方法类型
        Method method = clazz.getMethod(methodName2, String.class,int.class);//方法名 arg1 arg2
        Object obj2 = clazz.newInstance();//通过类获取构造器
        method.invoke(obj2, "wangcai",20);//构造器 参数1 参数2
      System.out.println("-----------------------------------");
      //静态方法
      String className3 = "org1.Reflect.Test";
      Class clazz3= Class.forName(className3);
      String methodName3 = "staticshow";
      Method method3 = clazz3.getMethod(methodName3);
      method3.invoke(null);//不初始化 不传参
    }
}

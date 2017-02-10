package org.spring.LifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by hadoop on 16-9-8.
 */
public class BeanFactory implements BeanNameAware,ApplicationContextAware {
    public static Animal2Impl getEat(){
        return new Animal2Impl();
    }
    public Animal2Impl getEat1(){
        return new Animal2Impl();
    }
    public void setup(){
        System.out.println("===初始化===");
    }
    public void destroy(){
        System.out.println("===destroy===");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("第三步:注入配置的类的名称"+s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第四步:注入applicationContext"+applicationContext);
    }
}

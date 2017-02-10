package org.spring.normal.demo2;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:04
 */
public class LifeCycle {

    public LifeCycle(){
        System.out.println("LifeCycle 实例被创建" + this.getClass());
    }

    public void init(){
        System.out.println("初始化LifeCycle 对象");
    }

    public void execute(){
        System.out.println("执行LifeCycle 处理");
    }

    public void destory(){
        System.out.println("LifeCycle 被销毁....");
    }
}

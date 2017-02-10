package org1.Reflect.myProxy;

/**
 * Created by hadoop on 16-10-13.
 * 总结proxy的概念
 * 通过test类将被代理类传入代理层
 *  1代理层把被代理类交给处理类处理 2代理层实现newProxyInstance改变代理类的classloader
 *  处理类继承invocationHandel 通过 反射类对象+工具类 并返回
 * ! 这里面最关键的就是classloader
 *
 *
 */
public class Test {
    public static void main(String[] args) {
        DogImpl target =new DeadDog();
        DogImpl dog =(DogImpl)MyProxyFactory.getProxy(target);
        dog.run();
        dog.bark();

    }
}

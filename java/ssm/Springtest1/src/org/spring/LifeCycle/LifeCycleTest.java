package org.spring.LifeCycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hadoop on 16-9-8.
 */
public class LifeCycleTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext appl =new ClassPathXmlApplicationContext("resource/ApplicationContext.xml");//上下文对象
//        //调用非静态的工厂方法
//        Animal2Impl bean3=appl.getBean("bean3",Animal2Impl.class);
//        bean3.eat("dog");
//        System.out.println(bean3+"调用非静态的工厂方法");
//        生命周期实例
            //AOP的factory拿到Animal2Impl
        Animal2Impl animal2= (Animal2Impl) appl.getBean("bean4");//通过bean4拿到 Animal2Impl.class
            //Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy1 cannot be cast to org.spring.LifeCycle.Animal2Impl
        System.out.println("通过bean4拿到 Animal2Impl.class====="+animal2);//org.spring.LifeCycle.Animal2Impl@5174e73d
        InvocationHandlerImpl invocationHandler =new InvocationHandlerImpl(animal2);

            animal2.eat("cat");

        BeanFactory beanFactory = (BeanFactory) appl.getBean("BeanFactory");

//        beanFactory.setBeanName("beanFactory");//改变工厂类配置文件的id
//        beanFactory.setApplicationContext(appl);
//        animal2.setName1("cat");


        appl.close();
    }
}

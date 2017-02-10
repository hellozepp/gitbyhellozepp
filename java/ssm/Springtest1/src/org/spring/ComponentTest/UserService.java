package org.spring.ComponentTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hadoop on 16-9-11.
 */
 @Service(value = "123")
//@Component(value = "123")
public class UserService {
    @Value(value = "xueba")
    private String info;
//    @Autowired()//类型
//    @Qualifier("userDao")//名称
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public String toString() {
        return "CustomerService{" +
                "info='" + info + '\'' +
                ", userDao=" + userDao +
                '}';
    }

    public void sayHello(){
        System.out.println("hello this is a component test");
    }
}

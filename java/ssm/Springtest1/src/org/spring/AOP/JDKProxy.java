package org.spring.AOP;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hadoop on 16-9-13.
 */
public class JDKProxy implements InvocationHandler {
    private UserDao userDao;

    public JDKProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao createProxy(){
        UserDao proxy= (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(),this);
        return proxy;
    }
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        if("update".equals(method.getName())){
            System.out.println("记录日志。");
           UserDao result = (UserDao) method.invoke(userDao,objects);
            return result;
        }
        return method.invoke(userDao,objects);
    }
}

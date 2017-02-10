package org.spring.AOP;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hadoop on 16-9-13.
 */

public class SpringTest {
    @Test
    public void test(){
        UserDao userDao =new UserDaoImpl();
      UserDao proxy = new JDKProxy(userDao).createProxy();
        proxy.add();
        proxy.update();
    }
}

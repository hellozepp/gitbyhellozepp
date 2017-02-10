package org.spring.ComponentHunhe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hadoop on 16-9-13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/resource/ComponentHunhe.xml")
public class TestDemo {
    @Autowired
    private CustomerService customerService;
    @Test
    public void test(){
        System.out.println(customerService.toString());
    }
}

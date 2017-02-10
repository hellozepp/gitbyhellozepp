package cn.hellozepp.ssm.mapper;

import cn.hellozepp.ssm.po.User;
import cn.hellozepp.ssm.po.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hadoop on 2017/1/8.
 */
public class UserInfoMapperTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }
    //添加用户
    @Test
    public void insertToUserInfo() throws Exception {
        UserInfo chenxing =new UserInfo();

        chenxing.setName("chenxing");
        chenxing.setUsername("02210131301");

        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        UserInfo userInfo=userMapper.checkUserByUsername(chenxing.getUsername());
        if (userInfo!=null){
            System.out.println("no");
        }
        else {
            userMapper.insertToUserInfo(chenxing);
            System.out.println("ok");
        }
    }
}

package cn.hellozepp.ssm.mapper;

import cn.hellozepp.ssm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {

	private ApplicationContext applicationContext;

	//在setUp这个方法得到spring容器
	//查不到为null
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testLogin() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User chenxing =new User();

		chenxing.setName("chenxing");
		chenxing.setUsername("02210131301");
		chenxing.setPassword("123123");

		User user =userMapper.login(chenxing);
		System.out.println("============");
		System.out.println(user);
	}

	@Test
	public void testRegister() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User chenxing =new User();


		chenxing.setUsername("02210131302");

		System.out.println(chenxing);
		User user =userMapper.login(chenxing);
		if(null==user){
			chenxing.setName("chenxing1");
			chenxing.setPassword("123123");
			userMapper.register(chenxing);
		}
		else {
				System.out.println("用户已存在");
				System.out.println("============");
				System.out.println(user);
		}

	}
	@Test
	public void testChangePass() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User chenxing =new User();

		chenxing.setName("chenxing");
		chenxing.setUsername("02210131301");
		User user1=userMapper.login(chenxing);
		if(user1==null){
			System.out.println("该用户不存在");
		}
		else {
			chenxing.setPassword("123123");
			userMapper.changePass(chenxing.getPassword());
		}


	}
	@Test
	public void testDelPass() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User chenxing =new User();

		chenxing.setName("chenxing");
		chenxing.setUsername("02210131301");
		User user1=userMapper.login(chenxing);
		if(user1==null){
			System.out.println("该用户不存在");
		}
		else {
			userMapper.delUserByUsername(chenxing);
			System.out.println("删除成功");
		}


	}



}

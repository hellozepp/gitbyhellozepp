package cn.itcast.spring3.demo2;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest2 {
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Test
	public void demo1(){
		User user = new User();
		user.setName("小胖");
		
		userDao.add(user);
	}
	
	@Test
	public void demo2(){
		User user = new User();
		user.setId(1);
		user.setName("小边");
		
		userDao.update(user);
	}
	
	@Test
	public void demo3(){
		User user = new User();
		user.setId(1);
		
		userDao.delete(user);
	}
	
	@Test
	public void demo4(){
		int count = userDao.findCount();
		System.out.println(count);
	}
	
	@Test
	public void demo5(){
		String name = userDao.findNameById(3);
		System.out.println(name);
	}
	
	@Test
	public void demo6(){
		User user = userDao.findById(3);
		System.out.println(user);
	}
	
	@Test
	public void demo7(){
		List<User> list = userDao.findAll();
		for (User user : list) {
			System.out.println(user);
		}
	}
}

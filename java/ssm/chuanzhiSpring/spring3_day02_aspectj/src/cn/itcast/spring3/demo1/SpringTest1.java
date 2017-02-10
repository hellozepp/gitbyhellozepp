package cn.itcast.spring3.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest1 {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Test
	public void demo1(){
		userDao.add();
		userDao.delete();
		userDao.update();
		userDao.find();
	}
}

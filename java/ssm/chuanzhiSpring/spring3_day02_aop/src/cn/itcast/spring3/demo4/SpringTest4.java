package cn.itcast.spring3.demo4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest4 {
	
	@Autowired
	@Qualifier("orderDaoProxy")
	private OrderDao orderDao;
	
	@Test
	public void demo1(){
		orderDao.add();
		orderDao.delete();
		orderDao.update();
		orderDao.find();
	}

}

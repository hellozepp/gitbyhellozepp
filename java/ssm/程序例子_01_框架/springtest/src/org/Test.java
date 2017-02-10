package org;

import org.aop.service.UserService;
import org.aop.service1.UserService2;
import org.beanditest.bean.ExampleBean1;
import org.beanditest.bean.MessageBean;
import org.beanditest1.service.AddEmpService2;
import org.beanditest1.service.DeleteEmpService2;
import org.beanditest1.service.UpdateEmpService2;
import org.beanditest1.util.AppConfig;
import org.ditest.service.TestService;
import org.ditest1.dao.EmpDAO;
import org.ditest1.dao.ExampleBean;
import org.ditest2.service.DeleteEmpService;
import org.ditest2.service.UpdateEmpService;
import org.service.ILogin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by andilyliao on 17-1-4.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String conf = "applicationContext.xml";
        String acpath = "//opt/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        ApplicationContext ac1 = new FileSystemXmlApplicationContext(acpath);

        System.out.println("=====================================================================================");

        ILogin login= (ILogin) ac.getBean("login");
        System.out.println(login.login("",""));
        TestService testService= (TestService) ac.getBean("testService",TestService.class);
        System.out.println(testService.testservice());
        System.out.println("=====================================================================================");


        EmpDAO empDAO2= (EmpDAO) ac.getBean("jdbcEmpDao2");
        empDAO2.add();

        EmpDAO empDAO3= (EmpDAO) ac.getBean("jdbcEmpDao3");
        empDAO3.add();

        EmpDAO empDAO4= (EmpDAO) ac.getBean("jdbcEmpDao4");
        empDAO4.add();

        ExampleBean exampleBean= (ExampleBean) ac1.getBean("exampleBean");
        exampleBean.execute();
        ((FileSystemXmlApplicationContext)ac1).close();
        System.out.println("=====================================================================================");

        DeleteEmpService deleteEmpService= (DeleteEmpService) ac.getBean("deleteEmpService");
        deleteEmpService.deleteEmp();

        DeleteEmpService deleteEmpService1= (DeleteEmpService) ac.getBean("deleteEmpService1");
        deleteEmpService1.deleteEmp();

        UpdateEmpService updateEmpService= (UpdateEmpService) ac.getBean("updateEmpService");
        updateEmpService.updateEmp();
        System.out.println("=====================================================================================");

        MessageBean bean = (MessageBean)ac.getBean("messagebean");
        bean.execute();

        ExampleBean1 bean1 = ac.getBean("exampleBean1",ExampleBean1.class);
        bean1.execute();
        System.out.println("=====================================================================================");

        AppConfig config = ac.getBean("appConfig",AppConfig.class);
        System.out.println(config.getUsername());
        System.out.println(config.getPassword());

        AddEmpService2 addEmpService2= (AddEmpService2) ac.getBean("addEmpService2");
        addEmpService2.addEmp();

        DeleteEmpService2 deleteEmpService2= (DeleteEmpService2) ac.getBean("deleteEmpService2");
        deleteEmpService2.deleteEmp();

        UpdateEmpService2 updateEmpService2= (UpdateEmpService2) ac.getBean("updateEmpService2");
        updateEmpService2.updateEmp();

        System.out.println("=====================================================================================");

        UserService userService = (UserService)ac.getBean("userserivce");
        userService.update();
        try {
            userService.save();
        }catch(Exception e){

        }
        userService.delete();

        System.out.println("=====================================================================================");

        UserService userService1 = (UserService)ac.getBean("userservice1");
        userService1.update();
        try {
            userService1.save();
        }catch(Exception e){

        }
        userService1.delete();

        System.out.println("=====================================================================================");

        UserService2 userService2 = (UserService2)ac.getBean("userServiceImpl2");
        userService2.update();

    }
}

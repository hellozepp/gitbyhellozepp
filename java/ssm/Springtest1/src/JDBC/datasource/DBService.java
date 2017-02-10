package JDBC.datasource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hadoop on 16-9-4.
 */
public class DBService {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("resource/application.xml");
        DAO dao = (DAO) applicationContext.getBean("DAO");
        dao.login("xxx","xxx");

    }
}

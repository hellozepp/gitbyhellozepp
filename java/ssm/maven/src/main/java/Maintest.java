import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Maintest {
    public static void main(String[] args) {
        ApplicationContext apc= new ClassPathXmlApplicationContext("spring-mvc.xml");
        Persion persion= (Persion) apc.getBean("persion");
        System.out.println(persion.toString());
        System.out.println(persion.getName());

    }
}

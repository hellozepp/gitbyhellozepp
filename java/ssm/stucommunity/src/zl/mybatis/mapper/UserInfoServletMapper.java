package zl.mybatis.mapper;

import cn.hellozepp.ssm.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hadoop on 2017/1/12.
 */
@WebServlet(name = "UserInfoServletMapper")
public class UserInfoServletMapper extends HttpServlet {
    static String username=null;
    static String password=null;
    private ApplicationContext applicationContext;

    @Override
    public void init() throws ServletException {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}

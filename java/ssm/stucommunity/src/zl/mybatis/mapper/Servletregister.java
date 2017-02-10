package zl.mybatis.mapper;

import cn.hellozepp.ssm.mapper.UserMapper;
import cn.hellozepp.ssm.po.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by hadoop on 2017/1/7.
 */
@WebServlet(name = "Servletregister")
public class Servletregister extends HttpServlet {
    private ApplicationContext applicationContext;

    @Override
    public void init() throws ServletException {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

        System.out.println("register");
        User user =new User();
        String name =request.getParameter("name").trim();
        String password =request.getParameter("password").trim();
        String username =request.getParameter("username").trim();
        if(name.equals("")||password.equals("")||username.equals("")){
            response.getWriter().write("101");
        }else{
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("register:"+user);
            try {
                User user1 =new User();
                user1 = userMapper.login(user);
                if (user1==null){
                    response.getWriter().write("1");
                }
                else response.getWriter().write("0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}

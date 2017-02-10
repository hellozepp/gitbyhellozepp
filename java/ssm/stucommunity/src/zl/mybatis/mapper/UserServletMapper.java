package zl.mybatis.mapper;

import cn.hellozepp.ssm.mapper.UserMapper;
import cn.hellozepp.ssm.po.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hadoop on 2017/1/6.
 */
@WebServlet(name = "UserServletMapper")
public class UserServletMapper extends HttpServlet {
    static String username=null;
    static String password=null;
    private ApplicationContext applicationContext;

    @Override
    public void init() throws ServletException {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    }

    //在setUp这个方法得到spring容器
//    @Before//这里的bean不被servlset加载 要在下一层用
//    public void setUp() throws Exception {
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");


        username = request.getParameter("username");
        System.out.println("===="+username+"====");
        password = request.getParameter("password");
        System.out.println("===="+password+"====");

        User userlogin =new User();
        userlogin.setUsername(username);
        userlogin.setPassword(password);
        
        User user1 = null;
        try {
            user1 = userMapper.login(userlogin);
            if(null==user1){
                response.getWriter().write("0");
            }
            else response.getWriter().write("1");
            System.out.println("后台获取用户信息："+user1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }


}

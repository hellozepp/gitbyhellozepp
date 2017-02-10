package CookieTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hadoop on 16-8-28.
 */
@WebServlet(name = "ServletCookie")
public class ServletCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取所有cookie
        response.setContentType("text/html;charset=UTF-8");
        Cookie [] cookies =request.getCookies();
        //2. 如果第一次访问,返回欢迎,记录本次cookie时间,返回浏览器
       Cookie cookie =CookieUtil.getCookieByName(cookies,"last");
        if (cookie==null){
            response.getWriter().write("<h3>欢迎访问!!!</h3>");
        }
        //3. 如果访问过.返回当前时间,记录cookie时间,返回;浏览器
        else{
            String value =cookie.getValue();
            response.getWriter().write("<h3>欢迎访问!!!上次登录时间为"+value+"</h3>");
        }
        String sdate =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Cookie c =new Cookie("last",sdate);
        response.addCookie(c);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}

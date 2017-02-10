package tools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by andilyliao on 16-8-31.
 */
public class Tools extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Enumeration<String> pns=request.getParameterNames();
        Class c= null;
        Object obj=null;
        try {
            c = Class.forName(request.getParameter("userbean"));
            obj=c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        while (pns.hasMoreElements()){
            try {
                String str=pns.nextElement();
                if(str.equalsIgnoreCase("userbean")||str.equalsIgnoreCase("path")){
                    continue;
                }
                Method method = c.getMethod("set"+str.substring(0,1).toUpperCase()+str.substring(1,str.length()), String.class);
                method.invoke(obj,request.getParameter(str));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        try {
            File f=new File("/opt/testweb11/myweb1/src/aaa.properties");
            InputStream in=new FileInputStream(f);
            Properties p=new Properties();
            p.load(in);
            String beanname=(String)p.get(request.getParameter("path"));
            Aaa a= (Aaa) Class.forName(beanname).newInstance();
            String url=a.doservcie(obj);
            request.getRequestDispatcher(url).forward(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

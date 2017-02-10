package Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * Created by hadoop on 16-9-7.
 */
public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session =httpSessionEvent.getSession();
        ServletContext servletContext= session.getServletContext();
        List<HttpSession> sessions= (List<HttpSession>) servletContext.getAttribute("sessions");
        sessions.add(session);
        System.out.println(session.getId() + " 添加到了集合");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}

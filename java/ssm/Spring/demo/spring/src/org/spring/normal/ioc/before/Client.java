package org.spring.normal.ioc.before;

/**
 * Created by LeoAshin on 16/9/4.
 * in 上午1:33
 */
public class Client {

    public static void main(String[] args) {
        UserService service = new UserServiceImp();

        service.addNewUser("LeoAshin", "password");
    }
}

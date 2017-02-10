package before;

/**
 * Created by hadoop on 16-9-4.
 */
public interface UserDao {
    void login(String name, String pass);
    boolean findPwdByUserName(String pass);
}

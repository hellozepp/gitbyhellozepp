package proxy.staticProxy;

import org.junit.Test;

/**
 * Created by hadoop on 2017/1/21.
 */
public class TestStaticProxy {
    @Test
    public void aaa(){
        Clazz a =new ClazzImpl();
        JavaStaticProxy proxy =new JavaStaticProxy(a);
        proxy.option1();
    }
}

package proxy.staticProxy;

/**
 * Created by hadoop on 2017/1/21.
 */
public class ClazzImpl implements Clazz {
    ClazzImpl(){};
    @Override
    public void option1() {

        System.out.println("realsubject operatestarted......");
    }
}

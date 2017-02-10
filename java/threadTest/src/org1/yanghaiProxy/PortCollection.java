package org1.yanghaiProxy;

import java.util.HashMap;

/**
 * Created by yh on 16-11-3.
 */
public class PortCollection {
    public static HashMap<Integer,Integer> hashMap = new HashMap<>();
    static {
        hashMap.put(0,8080);
        hashMap.put(1,8081);
        hashMap.put(2,8082);
    }
    public static Integer getPort(int n){
        return  hashMap.get(n);
    }
}

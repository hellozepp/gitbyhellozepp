package org.Grouptest;

import java.util.HashMap;

/**
 * Created by hadoop on 16-8-10.
 */
public class Contral extends Thread {

    public HashMap getHashMap() {
        return hashMap;
    }
    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    private HashMap<String,Thread> hashMap;
    public void run(){
        for (String key:hashMap.keySet()){
            Thread t=hashMap.get(key);
            t.start();
        }
    }
}

package org.ThreadJoin;

import java.util.HashMap;

/**
 * Created by hadoop on 16-8-9.
 */
public class C extends Thread {
    public HashMap<String, Thread> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, Thread> hashMap) {
        this.hashMap = hashMap;
    }
    public C (String c){

    }

    private HashMap<String,Thread> hashMap;
}

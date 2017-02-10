package com.lakefarm.utils;

import java.util.UUID;

/**
 * Created by rxl on 17-2-4.
 */
public class GetRandom {

    public synchronized static String getUserId(){
        String id= UUID.randomUUID().toString().replace("-","");
        return id;
    }

}

package com.lakefarm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cxd on 2017/2/14.
 */
public class GetCurrentTime {
    public static String getNowTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }
}

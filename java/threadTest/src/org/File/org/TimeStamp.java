package org.File.org;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hadoop on 16-8-2.
 */
public class TimeStamp {
    public static void main(String[] args) {
        //测试1 format 字符转日期
        //parse 日期转string
        try {
            String time = "2011/07/29 14:50:11";
            Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(time);
            long unixTimestamp = date.getTime()/1000;
            System.out.println(unixTimestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //测试2

            Date date = new Date();
            long stamp =date.getTime()/1000;
            System.out.println(stamp);
            //测试2

            SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        System.out.println(sdf.format(stamp));
        try {
            System.out.println(sdf.parse(sdf.format(stamp)));//Date类型的原始数据
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}

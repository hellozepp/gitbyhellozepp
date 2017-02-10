package org.File.org;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hadoop on 16-8-2.
 */
public class CalndarTest {
    public static void main(String[] args) {
        /*
        * 月份少一位
        * 星期多一位
        * */
        String str_date =DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(new Date());
        String str_date1 =DateFormat.getDateTimeInstance().format(new Date());
        Date str_date2 =new Date();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(str_date2));
        System.out.println(str_date);
        System.out.println(str_date1);
        Calendar cal =Calendar.getInstance();
        System.out.println("获取时间偏移量"+cal.getTime());//获取时间偏移量
//        cal.set(1995,2,32,0,0,0);cal.setLenient(false);
        System.out.println("获取修改的时间"+cal.getTime());
        System.out.println("现在的年份为:" +cal.get(Calendar.YEAR) );
        System.out.println("现在的月份为:" + ((int)cal.get(Calendar.MONTH)+1));
        System.out.println("现在的号为:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("现在的号为:" + cal.get(Calendar.DATE));
        System.out.println("现在是星期:" +((int)cal.get(Calendar.DAY_OF_WEEK)-1));
        System.out.println("现在过了的天数为:" + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("现在几点:" + cal.get(Calendar.HOUR));
        System.out.println("现在几点:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("现在几毫秒:" + cal.get(Calendar.MILLISECOND));
        System.out.println("本月最后一天是:" + cal.getActualMaximum(Calendar.DATE));
        System.out.println("本月最后一天是:" + cal.getMaximum(Calendar.DATE));//不对

        System.out.println(Calendar.getInstance().get(Calendar.HOUR));;
        System.out.println(Calendar.DATE);//X
        System.out.println(Calendar.HOUR);//X
        cal.set(1995,2,12,0,0,0);
        int year =cal.get(Calendar.YEAR);
        int month = ((int)cal.get(Calendar.MONTH)+1);
        int date =cal.get(Calendar.DAY_OF_MONTH);
    }
}

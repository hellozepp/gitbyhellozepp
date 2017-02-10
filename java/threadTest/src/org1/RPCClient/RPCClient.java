package org1.RPCClient;

import java.net.Socket;

/**
 * Created by hadoop on 16-8-18.
 */
public class RPCClient{
    public static void main (String[] args) throws Exception {

        System.out.println("<<获取 天气>>");
        String city= "北京";
        Weather weather= new Weather();
        System.out.println(weather.getWeather(city));//调用了weather的实现类,继承getweather接口
    }
}

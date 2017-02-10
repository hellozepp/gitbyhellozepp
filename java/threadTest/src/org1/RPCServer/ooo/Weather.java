package org1.RPCServer.ooo;

import org1.RPCClient.*;

/**
 * Created by hadoop on 16-8-17.
 */
public class Weather implements org1.intf.GetWeather  {
//public class Weather   {
    private String weather="阴";
    private String city;
    public Weather() {
    }

    @Override
    public String getWeather(String city) {
        this.city=city;
        return city+"的天气情况 =>"+weather;//city+"天气"+weather
    }

}

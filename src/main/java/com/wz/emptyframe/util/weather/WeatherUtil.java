package com.wz.emptyframe.util.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author ta0546 wz
 * @time 2019/9/30
 */
@Component
public class WeatherUtil {

    private static final String LOCATION_PARAM = "?location=";
    private static final String AND_KEY = "&key=";

    @Value("${weather.url}")
    private String url;

    @Value("${weather.key}")
    private String key;

    @Value("${weather.defaultLocation}")
    private String defaultLocation;

    @Value("${weather.weatherType}")
    private String weatherType;

    @Value("${weather.lifestyle}")
    private String lifestyle;


    @Autowired
    private RestTemplate restTemplate;


    public String getWeather() {
        String message = "";

        String locationMsg = "";
        String todayWeather = "";
        String tomorrowWeather = "";

        //获取3天天气情况
        Map weatherMap = restTemplate.getForObject(url + weatherType + LOCATION_PARAM + defaultLocation + AND_KEY + key, Map.class);
        List<Object> list =  (List<Object>)weatherMap.get("HeWeather6");
        if (list.size() >= 1) {
            Map<String,Object> bigMap = (Map<String,Object>)list.get(0);
            Map<String,String> basicMap = (Map<String,String>)bigMap.get("basic");
            locationMsg = basicMap.get("admin_area") + basicMap.get("location");

            List<Map<String,String>> dailyForecastMap = (List<Map<String,String>>)bigMap.get("daily_forecast");
            //3天的天气数据
            if (dailyForecastMap.size() >= 3) {
                //获取今天的天气描述
                todayWeather = "今天" + getWeatherMsg(dailyForecastMap.get(0));
                //获取明天的天气描述
                tomorrowWeather = "明天" + getWeatherMsg(dailyForecastMap.get(1));
            }

        }
        message = locationMsg + todayWeather + tomorrowWeather;

        //获取生活指数提示
        //Map lifeMap = restTemplate.getForObject(url + lifestyle + LOCATION_PARAM + defaultLocation + AND_KEY + key, Map.class);


        return message;
    }


    /**
     * 从map中获取并拼接天气数据
     * @param map
     * @return
     */
    private String getWeatherMsg(Map<String,String> map) {
        String msg = "白天：" + map.get("cond_txt_d") + ",夜间：" + map.get("cond_txt_n")
                + ",气温：" + map.get("tmp_min") + "-" + map.get("tmp_max") + "℃,"
                + map.get("wind_dir") + map.get("wind_sc") + "级,"
                + "相对湿度" + map.get("hum") + "%";
        return msg;
    }

}

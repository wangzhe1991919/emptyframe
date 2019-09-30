package com.wz.emptyframe.task;

import com.wz.emptyframe.util.weather.WeatherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ta0546 wz
 * @time 2019/9/30
 */
@Component
@EnableScheduling
public class WeatherTask {

    @Autowired
    private WeatherUtil weatherUtil;

    @Scheduled(cron = "0/30 * * * * ? ")
    public void getWeather() {
        String weather = weatherUtil.getWeather();
        System.out.println(weather);
    }

}

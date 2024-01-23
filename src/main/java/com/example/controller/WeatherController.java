package com.example.controller;

import com.example.model.WeatherResponse;
import com.example.service.WeatherService;
import com.example.util.WeatherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController extends SpringBootServletInitializer {

    private final WeatherService weatherService;
    private final WeatherUtils weatherUtils;

    @Autowired
    public WeatherController(WeatherService weatherService, WeatherUtils weatherUtils) {
        this.weatherService = weatherService;
        this.weatherUtils = weatherUtils;
    }

@GetMapping("/weather")
public String getWeather(Model model) {
    String weatherForecast = weatherService.getWeatherForecast();
    String weatherCondition = weatherUtils.getWeatherCondition(weatherForecast);

    WeatherResponse response = new WeatherResponse(weatherForecast, weatherCondition);

    model.addAttribute("weatherResponse", response);
    return "weather";
}

}

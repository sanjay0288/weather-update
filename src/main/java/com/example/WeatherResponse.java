package com.example.model;

public class WeatherResponse {

    private String forecast;
    private String condition;

    // Constructors, getters, and setters

    public WeatherResponse() {
    }

    public WeatherResponse(String forecast, String condition) {
        this.forecast = forecast;
        this.condition = condition;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}

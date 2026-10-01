package com.ai.agents.weathers.api.controller;


import com.ai.agents.weathers.api.dto.CityWeather;
import com.ai.agents.weathers.api.dto.DailyForecast;
import com.ai.agents.weathers.api.services.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(
            WeatherService weatherService) {

        this.weatherService = weatherService;
    }

    @GetMapping
    public CityWeather getWeather(
            @RequestParam String city) {

        return weatherService.getWeather(city);
    }

    @GetMapping("/forecast")
    public List<DailyForecast> getForecast(
            @RequestParam String city,
            @RequestParam(defaultValue = "10") int days) {

        return weatherService.getForecast(city, days);
    }

}
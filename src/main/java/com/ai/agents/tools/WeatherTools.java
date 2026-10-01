package com.ai.agents.tools;

import com.ai.agents.service.WeatherFetchService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class WeatherTools {

    private final WeatherFetchService weatherFetchService;

    public WeatherTools(WeatherFetchService weatherFetchService) {
        this.weatherFetchService = weatherFetchService;
    }
    @Tool(description = "Get the current weather for a given city")
    public String getWeather(String city) {
        return weatherFetchService.fetchBerlinWeather(city).toString();
    }
}

package com.ai.agents.weathers.api.dto;
import java.util.List;

public record WeatherData(
        int forecastDays,
        List<CityWeather> cities
) {
}

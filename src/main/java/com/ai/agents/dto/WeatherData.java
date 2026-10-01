package com.ai.agents.dto;

import java.util.List;

public record WeatherData(
        int forecastDays,
        List<CityWeather> cities
) {
}

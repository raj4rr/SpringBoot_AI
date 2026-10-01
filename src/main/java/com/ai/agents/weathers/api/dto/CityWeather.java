package com.ai.agents.weathers.api.dto;

import java.util.List;

public record CityWeather(
        Location location,
        List<DailyForecast> forecast
) {
}
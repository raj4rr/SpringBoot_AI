package com.ai.agents.dto;

import java.util.List;

public record CityWeather(
        Location location,
        List<DailyForecast> forecast
) {
}
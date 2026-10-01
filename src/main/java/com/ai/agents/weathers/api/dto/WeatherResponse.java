package com.ai.agents.weathers.api.dto;

import java.util.List;

public record WeatherResponse(
        Location location,
        CurrentWeather current,
        Forecast forecast,
        List<HourlyForecast> hourlyForecast,
        List<WeatherAlert> alerts,
        Recommendations recommendations,
        Summary summary,
        Metadata metadata
) {}
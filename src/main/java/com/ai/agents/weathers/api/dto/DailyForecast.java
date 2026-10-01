package com.ai.agents.weathers.api.dto;

public record DailyForecast(
        String date,
        String day,
        String condition,
        Temperature temperature,
        FeelsLike feelsLike,
        Precipitation precipitation,
        Humidity humidity,
        Wind wind,
        Integer cloudCover,
        Integer uvIndex,
        Sun sun,
        AirQuality airQuality
) {}
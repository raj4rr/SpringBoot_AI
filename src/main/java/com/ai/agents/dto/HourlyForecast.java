package com.ai.agents.dto;

public record HourlyForecast(
        String time,
        double temperature,
        double feelsLike,
        String condition,
        int precipitationProbability,
        double precipitationAmount,
        int humidity,
        double windSpeed,
        String windDirection,
        int cloudCover,
        int uvIndex
) {}

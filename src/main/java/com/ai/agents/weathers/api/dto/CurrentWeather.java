package com.ai.agents.weathers.api.dto;

public record CurrentWeather(
        double temperature,
        double feelsLike,
        String temperatureUnit,
        String condition,
        int conditionCode,
        String description,
        int humidity,
        int pressure,
        String pressureUnit,
        double visibility,
        String visibilityUnit,
        Wind wind,
        Precipitation precipitation,
        int cloudCover,
        int uvIndex,
        double dewPoint,
        Sun sun
) {}


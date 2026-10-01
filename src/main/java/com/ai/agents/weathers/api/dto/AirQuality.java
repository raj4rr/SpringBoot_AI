package com.ai.agents.weathers.api.dto;

public record AirQuality(
        int aqi,
        double pm25,
        double pm10,
        double o3,
        double no2
) {}

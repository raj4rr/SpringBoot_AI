package com.ai.agents.weathers.api.dto;


public record WeatherAlert(
        String type,
        String severity,
        String title,
        String description,
        String startTime,
        String endTime
) {}
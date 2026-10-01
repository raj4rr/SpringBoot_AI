package com.ai.agents.dto;


public record WeatherAlert(
        String type,
        String severity,
        String title,
        String description,
        String startTime,
        String endTime
) {}
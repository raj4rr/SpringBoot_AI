package com.ai.agents.weathers.api.dto;

public record Wind(
        double speed,
        double gust,
        String direction,
        int directionDegrees,
        String unit
) {}

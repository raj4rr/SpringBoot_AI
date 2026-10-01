package com.ai.agents.dto;

public record Wind(
        double speed,
        double gust,
        String direction,
        int directionDegrees,
        String unit
) {}

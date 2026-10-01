package com.ai.agents.weathers.api.dto;


public record Precipitation(
        double amount,
        String unit,
        int probability
) {}
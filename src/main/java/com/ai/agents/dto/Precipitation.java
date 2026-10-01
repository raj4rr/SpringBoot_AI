package com.ai.agents.dto;


public record Precipitation(
        double amount,
        String unit,
        int probability
) {}
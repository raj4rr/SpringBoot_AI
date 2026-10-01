package com.ai.agents.weathers.api.dto;

public record Recommendations(
        boolean umbrella,
        boolean jacket,
        boolean sunglasses,
        String outdoorActivity,
        String travelRisk,
        String drivingConditions
) {}
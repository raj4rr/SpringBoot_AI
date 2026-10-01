package com.ai.agents.dto;

public record Recommendations(
        boolean umbrella,
        boolean jacket,
        boolean sunglasses,
        String outdoorActivity,
        String travelRisk,
        String drivingConditions
) {}
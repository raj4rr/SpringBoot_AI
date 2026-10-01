package com.ai.agents.weathers.api.dto;

public record Temperature(
        Double min,
        Double max,
        Double morning,
        Double afternoon,
        Double evening,
        Double night
) {}
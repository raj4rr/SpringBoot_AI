package com.ai.agents.dto;

public record Temperature(
        Double min,
        Double max,
        Double morning,
        Double afternoon,
        Double evening,
        Double night
) {}
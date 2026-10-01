package com.ai.agents.weathers.api.dto;

public record Summary(
        String today,
        String tomorrow,
        String trend
) {}
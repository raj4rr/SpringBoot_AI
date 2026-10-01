package com.ai.agents.weathers.api.dto;

public record Metadata(
        String source,
        String lastUpdated,
        String units,
        int forecastDays
) {}
package com.ai.agents.dto;

public record Metadata(
        String source,
        String lastUpdated,
        String units,
        int forecastDays
) {}
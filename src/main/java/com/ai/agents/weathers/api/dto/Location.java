package com.ai.agents.weathers.api.dto;

public record Location(
        String city,
        String state,
        String country,
        String countryCode,
        Double latitude,
        Double longitude,
        String timezone,
        String localTime
) {}

package com.ai.agents.dto;

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

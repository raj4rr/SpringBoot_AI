package com.ai.agents.weathers.api.dto;

import java.util.List;

public record Forecast(
        List<DailyForecast> daily
) {}
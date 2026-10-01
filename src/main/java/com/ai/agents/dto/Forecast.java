package com.ai.agents.dto;

import java.util.List;

public record Forecast(
        List<DailyForecast> daily
) {}
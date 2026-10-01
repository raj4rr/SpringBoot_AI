package com.ai.agents.service;

import com.ai.agents.client.WeatherClient;
import com.ai.agents.dto.CityWeather;
import org.springframework.stereotype.Service;

@Service
public class WeatherFetchService {

    private final WeatherClient weatherClient;

    public WeatherFetchService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public CityWeather fetchBerlinWeather(String city) {
        return weatherClient.getWeather(city);
    }
}

package com.ai.agents.weathers.api.services;

import com.ai.agents.weathers.api.dto.CityWeather;
import com.ai.agents.weathers.api.dto.DailyForecast;
import com.ai.agents.weathers.api.dto.WeatherData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Service
public class WeatherService {

    private final WeatherData weatherData;

    public WeatherService(ObjectMapper objectMapper) {

        try {

            ClassPathResource resource =
                    new ClassPathResource("data.json");

            InputStream inputStream =
                    resource.getInputStream();

            this.weatherData =
                    objectMapper.readValue(
                            inputStream,
                            WeatherData.class
                    );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to load weather-data.json",
                    e
            );
        }
    }

    public CityWeather getWeather(String city) {

        return weatherData.cities()
                .stream()
                .filter(c ->
                        c.location()
                                .city()
                                .equalsIgnoreCase(city)
                )
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(
                                "City not found: " + city
                        )
                );
    }

    public List<DailyForecast> getForecast(
            String city,
            int days) {

        CityWeather cityWeather =
                getWeather(city);

        return cityWeather.forecast()
                .stream()
                .limit(days)
                .toList();
    }
}
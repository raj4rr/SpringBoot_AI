package com.ai.agents.client;
import com.ai.agents.dto.CityWeather;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherClient {

    private final RestClient restClient;

    public WeatherClient() {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    public CityWeather getWeather(String city) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/weather")
                        .queryParam("city", city)
                        .build())
                .retrieve()
                .body(CityWeather.class);
    }
}

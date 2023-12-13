package ru.sberbank.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;


@ComponentScan("ru.sberbank.edu")
@PropertySource("app.properties")
@Configuration
public class AppConfig {

    @Value("${appKey}")
    private String apiKey;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public WeatherProvider getWeatherProvider(RestTemplate getRestTemplate){
        return new WeatherProvider(getRestTemplate, apiKey);
    }
    @Bean
    public WeatherCache weatherCache(WeatherProvider weatherProvider){
        return new WeatherCache(weatherProvider);
    }

}

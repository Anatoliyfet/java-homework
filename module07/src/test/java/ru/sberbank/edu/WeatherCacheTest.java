package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherCacheTest {

    @Test
    void getWeatherInfoTrue() {

        WeatherCache weatherCache = new WeatherCache(new WeatherProvider());
        WeatherInfo weatherInfo1 = weatherCache.getWeatherInfo("London");
        WeatherInfo weatherInfo2 = weatherCache.getWeatherInfo("London");

        Assertions.assertThat(weatherInfo1.getDescription().toUpperCase())
                .isEqualTo(weatherInfo2.getDescription().toUpperCase());
    }
    @Test
    void getWeatherInfoFalse() {

        WeatherCache weatherCache = new WeatherCache(new WeatherProvider());
        WeatherInfo weatherInfo1 = weatherCache.getWeatherInfo("London");
        WeatherInfo weatherInfo2 = weatherCache.getWeatherInfo("Moscow");

        Assertions.assertThat(weatherInfo1)
                .isNotEqualTo(weatherInfo2);
    }
}
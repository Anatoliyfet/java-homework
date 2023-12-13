package ru.sberbank.edu;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class WeatherCache {

    private final Map<String, WeatherInfo> cache = new HashMap<>();
    private final WeatherProvider weatherProvider;

    /**
     * Constructor.
     *
     * @param weatherProvider - weather provider
     */
    public WeatherCache(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    /**
     * Get ACTUAL weather info for current city or null if current city not found.
     * If cache doesn't contain weather info OR contains NOT ACTUAL info then we should download info
     * If you download weather info then you should set expiry time now() plus 5 minutes.
     * If you can't download weather info then remove weather info for current city from cache.
     *
     * @param city - city
     * @return actual weather info
     */
    public synchronized WeatherInfo getWeatherInfo(String city) {
        // should be implemented
        long minutes = 0;
        WeatherInfo weatherInfoCashe = cache.get(city);

//        WeatherProvider weatherProvider = new WeatherProvider();
        WeatherInfo weatherInfo = weatherProvider.get(city);

        if (weatherInfo == null) {
            removeWeatherInfo(city);
            return null;
        }

        if (weatherInfoCashe != null) {
//            weatherInfoCashe = weatherInfo;
            minutes = weatherInfo.getExpiryTime().until(weatherInfoCashe.getExpiryTime(), ChronoUnit.MINUTES);
        }


        weatherInfoCashe = addWeatherInfoToCashe(city, weatherInfoCashe, weatherInfo, minutes);


        return weatherInfoCashe;
    }

    private WeatherInfo addWeatherInfoToCashe(String city, WeatherInfo weatherInfoCashe, WeatherInfo weatherInfo, long minutes) {
        if (weatherInfoCashe == null) {
            addWeatherInfo(city, weatherInfo);
            return weatherInfo;
        }


        if ((weatherInfoCashe != null && minutes > 5) || !(weatherInfoCashe.equals(weatherInfo))) {
            addWeatherInfo(city, weatherInfo);
            weatherInfoCashe = weatherInfo;
        }
        return weatherInfoCashe;
    }

    public void addWeatherInfo(String city, WeatherInfo weatherInfo) {
        weatherInfo.setExpiryTime(LocalDateTime.now().plusMinutes(5));
        cache.put(city, weatherInfo);
    }

    /**
     * Remove weather info from cache.
     **/
    public void removeWeatherInfo(String city) {
        // should be implemented
        cache.remove(city);
    }
}

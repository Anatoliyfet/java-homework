package ru.sberbank.edu;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class WeatherProvider {

    //    private RestTemplate restTemplate = null;
    final String URL = "http://api.openweathermap.org/data/2.5/weather";
    final String API_KEY = "4f001a41f45c5bb59ed6db3774e317d5";
    private RestTemplate restTemplate;
    String apiKey;

    public WeatherProvider(RestTemplate restTemplate, String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }
    /**
     * Download ACTUAL weather info from internet.
     * You should call GET http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
     * You should use Spring Rest Template for calling requests
     *
     * @param city - city
     * @return weather info or null
     */
    public WeatherInfo get(String city) {
//        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder
                .fromUriString(URL)
                .queryParam("q", city)
                .queryParam("appid", API_KEY)
//                .encode()
                .build()
                .toUri();

        WeatherInfoDto page = restTemplate.getForObject(uri, WeatherInfoDto.class);

        WeatherInfoMapper weatherInfoMapper = new WeatherInfoMapper();
        WeatherInfo weatherInfo = weatherInfoMapper.mapWeatherInfo(page);
        //test
//        System.out.println(weatherInfo.getCity());
//        System.out.println(weatherInfo.getShortDescription());
//        System.out.println(weatherInfo.getTemperature());

        return weatherInfo;
    }


}

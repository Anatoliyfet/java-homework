package ru.sberbank.edu;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Need to use DozerBeanMapper or MapperStruct
 * https://javarush.com/groups/posts/3698-chto-takoe-mapstruct-i-kak-praviljhno-nastroitjh-ego-dlja-moduljhnogo-testirovanija-v-springboo
 * or other best practices?
 */
public class WeatherInfoMapper {


    public WeatherInfo mapWeatherInfo(WeatherInfoDto weatherInfoDto) {
        WeatherInfo weatherInfo = new WeatherInfo();
        //city
        weatherInfo.setCity(weatherInfoDto.getName());
        //Descriptions
        weatherInfo.setDescription(weatherInfoDto.getWeather().get(0).getDescription());
        weatherInfo.setShortDescription(weatherInfoDto.getWeather().get(0).getMain());
        //WindSpeed
        weatherInfo.setWindSpeed(weatherInfoDto.getWind().getSpeed());
        //Temps and Pressure
        weatherInfo.setPressure(weatherInfoDto.getMain().getPressure());
        weatherInfo.setTemperature(weatherInfoDto.getMain().getTemp());
        weatherInfo.setFeelsLikeTemperature(weatherInfoDto.getMain().getFeels_like());
        //Local date time
        weatherInfo.setExpiryTime(LocalDateTime.now());

        return weatherInfo;
    }
}

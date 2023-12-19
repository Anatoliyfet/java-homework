package ru.sberbank.edu;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

    //+ name
    private String city;


    /**
     * weather.0.main
     * Short weather description
     * Like 'sunny', 'clouds', 'raining', etc
     */
    private String shortDescription;

    /**
     * Weather description.
     * Like 'broken clouds', 'heavy raining', etc
     */
    private String description;

    /**
     * main": {
     * "temp": 285.83,
     * <p>
     * Temperature.
     */
    private double temperature;

    /**
     * main
     * "feels_like": 285.27,
     * Temperature that fells like.
     */
    private double feelsLikeTemperature;

    /**
     * "main"
     * Pressure.
     */
    private double pressure;

    /**
     * "wind": {
     * "speed": 7.72,
     * Wind speed.
     */
    private double windSpeed;


    /**
     * Expiry time of weather info.
     * If current time is above expiry time then current weather info is not actual!
     */
    private LocalDateTime expiryTime;

    public String getCity() {
        return city;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getPressure() {
        return pressure;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setFeelsLikeTemperature(double feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherInfo that = (WeatherInfo) o;
        return city.toUpperCase().equals(that.city.toUpperCase()) && shortDescription.toUpperCase().equals(that.shortDescription.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(city.toUpperCase(), shortDescription.toUpperCase());
    }
}

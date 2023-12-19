package ru.sberbank.edu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfoDto {
    private String name;
    private List<Weather> weather;
    private Wind wind;
    private Main main;
//    @JsonIgnoreProperties(ignoreUnknown = true)

    /**
     * weather object
     * main information of weather and long description
     */
    static class Weather {
        private String main;
        private String description;

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setMain(String main) {
            this.main = main;
        }
    }

    /**
     * temp, feels_like and pressure
     */
    static class Main {
        private double temp;
        private double feels_like;
        private double pressure;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getFeels_like() {
            return feels_like;
        }

        public void setFeels_like(double feels_like) {
            this.feels_like = feels_like;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }
    }

    /**
     * speed of wind
     */
    static class Wind {
        private double speed;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
    }

    /**
     * cityName
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * weather information list
     * @return
     */
    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * Main information
     *
     * @return
     */
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * Wind
     * @return
     */
    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}

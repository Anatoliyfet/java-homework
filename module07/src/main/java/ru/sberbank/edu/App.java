package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WeatherProvider weatherProvider = new WeatherProvider();

        System.out.println( weatherProvider.get("London").getDescription());

        WeatherCache weatherCache = new WeatherCache(new WeatherProvider());
        WeatherInfo weatherInfo1 = weatherCache.getWeatherInfo("London");
        WeatherInfo weatherInfo2 = weatherCache.getWeatherInfo("London");

        System.out.println(weatherInfo1.getDescription());
        System.out.println(weatherInfo2.getDescription());
    }
}

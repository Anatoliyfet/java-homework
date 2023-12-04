package ru.sberbank.edu;

import com.sun.source.tree.IfTree;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Travel Service.
 */
public class TravelService {
    public static final double EARTH_RADIUS = 6371; // Радиус Земли в километрах
    // do not change type
    private final List<CityInfo> cities = new ArrayList<>();

    /**
     * Append city info.
     *
     * @param cityInfo - city info
     * @throws IllegalArgumentException if city already exists
     */
    public void add(CityInfo cityInfo) throws IllegalArgumentException {
        // do something
//        cities.stream().filter( CityInfo -> cities.contains(cityInfo))
//                .findFirst
//                .orElseThrow((IllegalArgumentException::new));
        if (cities.contains(cityInfo)) {
            throw new IllegalArgumentException("We have this city already");
        } else {
            cities.add(cityInfo);
        }

    }

    /**
     * remove city info.
     *
     * @param cityName - city name
     * @throws IllegalArgumentException if city doesn't exist
     */
    public void remove(String cityName) throws IllegalArgumentException {
        // do something

        CityInfo city =
                cities.stream()
                        .filter(CityInfo -> cities.equals(cityName))
                        .findFirst()
                        .orElseThrow((IllegalArgumentException::new));
        cities.remove(city);
    }

    /**
     * Get cities names.
     */
    public List<String> citiesNames() {

        List<String> citiesNames =
                cities.stream()
                        .map(CityInfo::getName)
                        .collect(Collectors.toList());
        return citiesNames;
    }

    /**
     * Get distance in kilometers between two cities.
     * https://www.kobzarev.com/programming/calculation-of-distances-between-cities-on-their-coordinates/
     *
     * @param srcCityName  - source city
     * @param destCityName - destination city
     * @throws IllegalArgumentException if source or destination city doesn't exist.
     */
    public int getDistance(String srcCityName, String destCityName) {
        CityInfo cityFirst = getCityInfo(srcCityName);
        CityInfo citySecond = getCityInfo(destCityName);

        return calculateDistance(cityFirst, citySecond);
    }

    @Nullable
    private CityInfo getCityInfo(String srcCityName) {
        CityInfo cityFirst =
                cities.stream()
                        .filter(CityInfo -> srcCityName.equals(CityInfo.getName()))
                        .findFirst()
                        .orElse(null);
        return cityFirst;
    }

    private int calculateDistance(CityInfo cityFirst, CityInfo citySecond) {
        double lat1 = cityFirst.getPosition().getLatitude();
        double lon1 = cityFirst.getPosition().getLongitude();
        double lat2 = citySecond.getPosition().getLatitude();
        double lon2 = citySecond.getPosition().getLongitude();

        // Разницы между координатами
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // Формула Haversine
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Расстояние в километрах
        return (int) (EARTH_RADIUS * c);
    }

    /**
     * Get all cities near current city in radius.
     *
     * @param cityName - city
     * @param radius   - radius in kilometers for search
     * @throws IllegalArgumentException if city with cityName city doesn't exist.
     */
    public List<String> getCitiesNear(String cityName, int radius) {
        return null;
    }
}

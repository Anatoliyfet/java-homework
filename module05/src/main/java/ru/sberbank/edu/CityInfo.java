package ru.sberbank.edu;

import java.util.Objects;

/**
 * City info
 */
public class CityInfo {

    private String name;
    private GeoPosition position;


    /**
     * Ctor.
     *
     * @param name     - city name
     * @param position - position
     */
    public CityInfo(String name, GeoPosition position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityInfo cityInfo = (CityInfo) o;
        return name.equals(cityInfo.name.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toUpperCase());
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public GeoPosition getPosition() {
        return position;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "CityInfo{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    /**
     * @param position
     */
    public void setPosition(GeoPosition position) {
        this.position = position;
    }
}
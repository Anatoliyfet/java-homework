package ru.sberbank.edu;

import org.jetbrains.annotations.NotNull;

/**
 * Geo position.
 */
public class GeoPosition {

    /**
     * Широта в радианах.
     */
    private double latitude;

    /**
     * Долгота в радианах.
     */
    private double longitude;

    /**
     * Ctor.
     *
     * @param latitudeGradus  - latitude in gradus
     * @param longitudeGradus - longitude in gradus
     *                        Possible values: 55, 55(45'07''), 59(57'00'')
     */
    public GeoPosition(String latitudeGradus, String longitudeGradus) {
        // parse and set latitude and longitude in radian
        this.latitude = parseCoordinate(latitudeGradus);
        this.longitude = parseCoordinate(longitudeGradus);
    }

    private double parseCoordinate(@NotNull String coordinateString) {
        String[] parts = coordinateString.split("[^\\d]+");
        int degrees = Integer.parseInt(parts[0]);
        int minutes = (parts.length > 1) ? Integer.parseInt(parts[1]) : 0;
        int seconds = (parts.length > 2) ? Integer.parseInt(parts[2]) : 0;
        return Math.toRadians(degrees + minutes / 60.0 + seconds / 3600.0);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Latitude: " + Math.toDegrees(latitude) + ", Longitude: " + Math.toDegrees(longitude);
    }


}
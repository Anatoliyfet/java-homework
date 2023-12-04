package ru.sberbank.edu;

import org.assertj.core.api.Assertions;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelServiceTest {

    @Test
    void getDistanceTest() {
        TravelService travelService = getTravelService();

        Assertions.assertThat(travelService.getDistance("Nimki", "SecondCity"))
                .isNotZero()
                .isEqualTo(77)
                .isNotEqualTo(99);
    }

    @NotNull
    private TravelService getTravelService() {
        GeoPosition position = new GeoPosition("55(45'07'')", "59(57'00'')");
        GeoPosition positionSecond = new GeoPosition("15(47'07'')", "58(57'00'')");
        CityInfo city1 = new CityInfo("Nimki", position);
        CityInfo city2 = new CityInfo("SecondCity", positionSecond);

        TravelService travelService = new TravelService();
        travelService.add(city1);
        travelService.add(city2);
        return travelService;
    }
}
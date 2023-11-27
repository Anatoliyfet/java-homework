package ru.sberbank.edu;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // exercise 1
        doExerciseFirst();

    }

    private static void doExerciseFirst() {
        GeoPosition position = new GeoPosition("55(45'07'')", "59(57'00'')");
        GeoPosition positionSecond = new GeoPosition("15(47'07'')", "58(57'00'')");
        System.out.println(position.getLatitude());  // Выведет широту в радианах
        System.out.println(position.getLongitude());  // Выведет долготу в радианах
        System.out.println(position);  // Выведет строковое представление объекта

        CityInfo city1 = new CityInfo("Nimki", position);
        CityInfo city2 = new CityInfo("SecondCity", positionSecond);

        TravelService travelService = new TravelService();
        travelService.add(city1);
        travelService.add(city2);

        System.out.println(travelService.citiesNames());
        System.out.println(travelService.getDistance("Nimki", "SecondCity"));

    }


}

package org.example.task2;

import java.util.List;
import java.util.Map;

public interface Storage {

    void addCity(String cityName);
    void addConnection(String departureCity, String arrivalCity, Integer cost);
    List<String> getAllCities();
    Map<String, Integer> getReachableCities(String departureCity);
}

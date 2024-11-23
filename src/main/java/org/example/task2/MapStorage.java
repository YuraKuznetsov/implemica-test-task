package org.example.task2;

import java.util.*;

public class MapStorage implements Storage {

    private final Map<String, Map<String, Integer>> storage = new HashMap<>();

    @Override
    public void addCity(String cityName) {
       if (storage.containsKey(cityName))
           throw new IllegalArgumentException("City " + cityName + " already exists.");

       storage.put(cityName, new HashMap<>());
    }

    @Override
    public void addConnection(String departureCity, String arrivalCity, Integer cost) {
        if (!storage.containsKey(departureCity) || !storage.containsKey(arrivalCity))
            throw new IllegalArgumentException("Both departure and arrival cities must exist in storage.");

        Map<String, Integer> arrivalCities = storage.get(departureCity);
        arrivalCities.put(arrivalCity, cost);
        storage.put(departureCity, arrivalCities);
    }

    @Override
    public List<String> getAllCities() {
        return new ArrayList<>(storage.keySet());
    }

    @Override
    public Map<String, Integer> getReachableCities(String departureCity) {
        return Collections.unmodifiableMap(storage.get(departureCity));
    }
}

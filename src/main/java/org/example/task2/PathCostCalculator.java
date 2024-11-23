package org.example.task2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Class responsible for calculating the minimum cost path between two cities.
 * Implements Dijkstra's algorithm using a Storage interface for city data.
 */
public class PathCostCalculator {

    private static final int MAX_COST = 200_001;

    private final Storage storage;

    public PathCostCalculator(Storage storage) {
        this.storage = storage;
    }

    /**
     * Calculates the minimum cost to travel from the start city to the end city.
     *
     * @param startCity The name of the starting city.
     * @param endCity The name of the destination city.
     * @return The minimum cost to travel between the cities.
     * @throws IllegalStateException if no path exists between the cities.
     */
    public int calculate(String startCity, String endCity) {
        // Get the list of all city names from storage
        List<String> citiesNames = storage.getAllCities();
        int citiesNumber = citiesNames.size();

        // Array to store the minimum cost to each city
        int[] costs = new int[citiesNumber];

        // Array to track whether each city has been visited
        boolean[] visitedCities = new boolean[citiesNumber];

        // Initialize all costs to MAX_COST and set the cost of the start city to 0
        Arrays.fill(costs, MAX_COST);
        costs[citiesNames.indexOf(startCity)] = 0;

        for (int i = 0; i < citiesNumber; i++) {
            // Find the city with the minimum cost that has not been visited
            int minCostIndex = getMinCostIndex(costs, visitedCities);
            String minCostName = citiesNames.get(minCostIndex);

            // If the end city is reached, return its cost
            if (minCostName.equals(endCity))
                return costs[minCostIndex];

            // Mark the current city as visited
            visitedCities[minCostIndex] = true;

            // Get all directly connected cities and their costs
            Map<String, Integer> reachableCities = storage.getReachableCities(minCostName);

            // Update costs for reachable cities
            for (Map.Entry<String, Integer> city : reachableCities.entrySet()) {
                String cityName = city.getKey();
                int cityCost = city.getValue();
                int cityIndex = citiesNames.indexOf(cityName);

                // Skip cities that have already been visited
                if (visitedCities[cityIndex])
                    continue;

                // Update the cost to reach the city if a cheaper path is found
                costs[cityIndex] = costs[minCostIndex] + cityCost;
            }
        }

        // If the loop completes without finding a path, throw an exception
        throw new IllegalStateException("Can't find path from city " + startCity + " to city " + endCity + ".");
    }

    /**
     * Finds the index of the city with the smallest cost that has not been visited.
     *
     * @param costs Array of costs to each city.
     * @param visitedCities Array indicating whether a city has been visited.
     * @return The index of the city with the minimum cost.
     */
    private int getMinCostIndex(int[] costs, boolean[] visitedCities) {
        int minCost = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < costs.length; i++) {
            if (!visitedCities[i] && costs[i] <= minCost) {
                minCost = costs[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}

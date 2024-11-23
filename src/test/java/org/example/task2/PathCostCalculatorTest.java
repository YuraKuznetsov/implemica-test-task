package org.example.task2;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathCostCalculatorTest {

    @Test
    public void tes1() {
        PathCostCalculator costCalculator = new PathCostCalculator(getStorage());
        assertEquals(3, costCalculator.calculate("gdansk", "warszawa"));
    }

    @Test
    public void tes2() {
        PathCostCalculator costCalculator = new PathCostCalculator(getStorage());
        assertEquals(2, costCalculator.calculate("bydgoszcz", "warszawa"));
    }

    private Storage getStorage() {
        Storage storage = new MapStorage();

        storage.addCity("gdansk");
        storage.addCity("bydgoszcz");
        storage.addCity("torun");
        storage.addCity("warszawa");

        storage.addConnection("gdansk", "bydgoszcz", 1);
        storage.addConnection("gdansk", "torun", 3);
        storage.addConnection("bydgoszcz", "gdansk", 1);
        storage.addConnection("bydgoszcz", "torun", 1);
        storage.addConnection("bydgoszcz", "warszawa", 4);
        storage.addConnection("torun", "gdansk", 3);
        storage.addConnection("torun", "bydgoszcz", 1);
        storage.addConnection("torun", "warszawa", 1);
        storage.addConnection("warszawa", "bydgoszcz", 4);
        storage.addConnection("warszawa", "torun", 1);

        return storage;
    }
}
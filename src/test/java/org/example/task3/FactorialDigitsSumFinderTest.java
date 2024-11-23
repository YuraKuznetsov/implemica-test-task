package org.example.task3;

import org.junit.Test;
import static org.junit.Assert.*;

public class FactorialDigitsSumFinderTest {

    @Test
    public void testLargeFactorials() {
        assertEquals(
                "Sum of digits for 100! should be 648",
                648,
                FactorialDigitsSumFinder.sumFactorialDigits(100)
        );
    }
}

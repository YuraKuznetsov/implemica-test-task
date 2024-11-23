package org.example.task1;

import org.junit.Test;
import static org.junit.Assert.*;

public class CorrectBracketExpressionsTest {

    @Test
    public void testOnePairOfBracket() {
        assertEquals("Catalan number for N = 1 should be 1",
                1,
                CorrectBracketExpressions.calculateCatalanNumber(1));
    }

    @Test
    public void testTwoPairsOfBracket() {
        assertEquals("Catalan number for N = 2 should be 2",
                2,
                CorrectBracketExpressions.calculateCatalanNumber(2));
    }

    @Test
    public void testThreePairsOfBracket() {
        assertEquals("Catalan number for N = 3 should be 5",
                5,
                CorrectBracketExpressions.calculateCatalanNumber(3));
    }

    @Test
    public void testFourPairsOfBracket() {
        assertEquals("Catalan number for N = 4 should be 14",
                14,
                CorrectBracketExpressions.calculateCatalanNumber(4));
    }
}

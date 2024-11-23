package org.example.task1;

/**
 * A program to calculate the number of correct bracket expressions
 * that can be formed using N pairs of opening and closing parentheses.
 * This is based on the Catalan number formula.
 */
public class CorrectBracketExpressions {

    /**
     * Calculates the nth Catalan number, which represents the number of
     * correct bracket expressions that can be formed with n pairs of brackets.
     *
     * @param n the number of pairs of brackets
     * @return the nth Catalan number
     */
    public static int calculateCatalanNumber(int n) {
        return factorial(2 * n) / (factorial(n) * factorial(n + 1));
    }

    /**
     * Computes the factorial of a given number.
     *
     * @param num the number to compute the factorial for
     * @return the factorial of the given number as a BigInteger
     */
    private static int factorial(int num) {
        if (num == 1) return 1;
        return num * factorial(num - 1);
    }
}

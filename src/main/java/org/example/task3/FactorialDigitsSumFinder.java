package org.example.task3;

import java.util.stream.IntStream;

public class FactorialDigitsSumFinder {

    /**
     * Calculates the sum of digits of the factorial of a given number.
     * This implementation uses an array to simulate large factorials.
     *
     * @param n the number whose factorial's digit sum is to be calculated
     * @return the sum of digits of n!
     */
    public static int sumFactorialDigits(int n) {
        int[] array = new int[countDigits(n)];
        array[0] = 1;

        for (int i = 2; i <= n; i++) {
            multiply(array, i);
        }

        return IntStream.of(array).sum();
    }

    /**
     * Multiplies the current factorial representation by a number.
     * Updates the array in-place to store the result.
     *
     * @param array  the array representing the digits of the factorial in reverse order
     * @param number the number to multiply the factorial by
     */
    private static void multiply(int[] array, int number) {
        int carry = 0;

        for (int i = 0; i < array.length; i++) {
            int temp = array[i] * number + carry;
            array[i] = temp % 10;
            carry = temp / 10;
        }
    }

    /**
     * Estimates the number of digits in the factorial of n.
     *
     * @param n the number whose factorial's digit count is to be calculated
     * @return the number of digits in n!
     */
    private static int countDigits(int n) {
        if (n <= 1) {
            return 1;
        }

        double logSum = 0;
        for (int i = 2; i <= n; i++) {
            logSum += Math.log10(i);
        }

        return (int) Math.floor(logSum) + 1;
    }
}

package org.util;

import org.Constants;

/**
 * 05.06.2016
 * Created by Rodion.
 */
public class MathNetwork {
    public static int factorial(int n) {
        if (n < 1) return 1;
        System.out.println(n);
        return n * factorial(n - 1);
    }

    public static int countCombination(int index, int base) {
        return factorial(base) / (factorial(index) * factorial(base - index));
    }

}

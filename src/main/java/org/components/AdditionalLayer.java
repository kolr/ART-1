package org.components;

import org.Constants;

/**
 * 05.06.2016
 * Created by Rodion.
 */
public class AdditionalLayer {
    private int numberOfNeurons;
    private int[] objects;

    AdditionalLayer(int index) {
        this.numberOfNeurons = determineNumberOfNeurons(index);
    }

    public int getNumberOfNeurons() {
        return numberOfNeurons;
    }

    public int[] getObjects() {
        return objects;
    }

    private int determineNumberOfNeurons(int index) {
        return factorial(Constants.M) / (factorial(index) * factorial(Constants.M - index));
    }

    private int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
}

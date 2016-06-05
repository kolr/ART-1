package org.components;

import org.Constants;
import org.components.neurons.AdditionalNeuron;

/**
 * 05.06.2016
 * Created by Rodion.
 */
public class AdditionalLayer {
    private int index;
    private int numberOfNeurons;
    private int[] objects;
    private AdditionalNeuron[] neurons;

    AdditionalLayer(int index) {
        this.index = index;
        this.numberOfNeurons = determineNumberOfNeurons(index);
        this.neurons = new AdditionalNeuron[this.numberOfNeurons];
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

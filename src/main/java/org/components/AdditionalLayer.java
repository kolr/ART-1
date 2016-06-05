package org.components;

import org.Constants;
import org.components.neurons.AdditionalNeuron;
import org.util.MathNetwork;

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
        this.numberOfNeurons = MathNetwork.countCombination(index, Constants.M);
        this.neurons = new AdditionalNeuron[this.numberOfNeurons];
    }

    public int getNumberOfNeurons() {
        return numberOfNeurons;
    }

    public int[] getObjects() {
        return objects;
    }
}

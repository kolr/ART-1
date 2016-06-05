package org.components;

import org.Constants;
import org.components.neurons.AdditionalNeuron;
import org.util.Combinations;
import org.util.MathNetwork;

import java.util.HashMap;
import java.util.Map;

/**
 * 05.06.2016
 * Created by Rodion.
 */
public class AdditionalLayer {
    private int index;
    private int numberOfNeurons;
    private int[] objects;
    private Map<String, AdditionalNeuron> neurons;

    AdditionalLayer(int index) {
        this.index = index;
        this.numberOfNeurons = MathNetwork.countCombination(index, Constants.M);
        this.neurons = new HashMap<String, AdditionalNeuron>();
        initializeNeuronMap();
    }

    public int getNumberOfNeurons() {
        return numberOfNeurons;
    }

    public int[] getObjects() {
        return objects;
    }

    public Map<String, AdditionalNeuron> getNeurons() {
        return neurons;
    }

    private void initializeNeuronMap() {
//        String[] names = Combinations.getAllLists(Combinations.generateStringArray(Constants.M), this.index);
        for (int i = 0; i < this.numberOfNeurons; i++) {
            neurons.put(String.valueOf(i), new AdditionalNeuron(i, this.index));
        }
    }

}

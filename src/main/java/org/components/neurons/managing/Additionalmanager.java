package org.components.neurons.managing;

import org.Constants;
import org.components.AdditionalLayer;
import org.components.neurons.AdditionalNeuron;
import org.util.Generator;

/**
 * 05.06.2016
 * Created by Rodion.
 */
public class AdditionalManager {
    private int[] objects;
    private int currentIndex;

    public AdditionalManager() {
        objects = new int[Constants.M];
        this.currentIndex = 0;
    }

    public void addObjectClusterIndex(int cluster) {
        if (currentIndex < objects.length) {
            objects[currentIndex] = cluster;
            currentIndex++;
        }
    }

    public void resetIndex() {
        this.currentIndex = 0;
    }

    public AdditionalNeuron getNecessaryNeuron(AdditionalLayer[] additionalLayer) {
        AdditionalNeuron neuron = null;
        if (currentIndex >= 0) {
            neuron = additionalLayer[currentIndex - 1].getNeurons().get(Generator.generateString(this.objects));
        }
        return neuron;
    }
}

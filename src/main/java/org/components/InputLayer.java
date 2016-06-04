package org.components;

import org.Constants;

/**
 * 04.06.2016
 * Created by Rodion.
 */
public class InputLayer {
    private int[] inputLayerOutput;
    private int outputRate;

    public InputLayer() {
        this.inputLayerOutput = new int[Constants.N];
    }

    public void setNewObject(int[] object) {
        System.arraycopy(object, 0, this.inputLayerOutput, 0, Constants.N);
        outputRate = 0;
        for (int i = 0; i < Constants.N; i++) {
            outputRate += i;
        }
    }

    public int[] getInputLayerOutput() {
        return inputLayerOutput;
    }

    public int getOutputRate() {
        return outputRate;
    }
}

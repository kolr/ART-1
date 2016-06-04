package org.components;

import org.Constants;

/**
 * 04.06.2016
 * Created by Rodion.
 */
public class InputLayer {
    private int[] inputLayerOutput;

    public InputLayer() {
        this.inputLayerOutput = new int[Constants.N];
    }

    public void setNewObject(int[] object) {
        System.arraycopy(object, 0, this.inputLayerOutput, 0, Constants.N);
    }
}

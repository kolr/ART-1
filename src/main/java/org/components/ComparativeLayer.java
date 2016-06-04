package org.components;

import org.Constants;

/**
 * 04.06.2016
 * Created by Rodion.
 */
public class ComparativeLayer {
    private int[] comparativeLayerOutput;
    private double[][] bottomTopWeights;
    private boolean allowed;

    public ComparativeLayer() {
        comparativeLayerOutput = new int[Constants.N];
        bottomTopWeights = new double[Constants.M][Constants.N];
    }

    public void initializeBottomTopWeights() {
        for (int i = 0; i < Constants.M; i++) {
            for (int j = 0; j < Constants.N; j++) {
                this.bottomTopWeights[i][j] = (double) 1 / (Constants.N + 1);
            }
        }
    }

    public void determineComparativeOutput(int[] object) {
        System.arraycopy(object, 0, comparativeLayerOutput, 0, comparativeLayerOutput.length);
    }

    public double[][] getBottomTopWeights() {
        return this.bottomTopWeights;
    }

    public int[] getComparativeLayerOutput() {
        return comparativeLayerOutput;
    }
}

package org.components;

import org.Constants;

/**
 * 04.06.2016
 * Created by Rodion.
 */
public class ComparativeLayer {
    private int[] comparativeLayerOutput;
    private double[][] bottomTopWeights;

    public ComparativeLayer() {
        comparativeLayerOutput = new int[Constants.N];
        bottomTopWeights = new double[Constants.M][Constants.N];
        initializeBottomTopWeights();
    }

    public void initializeBottomTopWeights() {
        for (int i = 0; i < Constants.M; i++) {
            for (int j = 0; j < Constants.N; j++) {
                this.bottomTopWeights[i][j] = (double) 1 / (Constants.N + 1);
            }
        }
    }

    public void changeBottomTopWeights(int[] zOut, int cluster) {
        for (int j = 0; j < Constants.N; j++) {
            this.bottomTopWeights[cluster][j] = (double) (Constants.L * zOut[j]) / (Constants.L - 1 + Net.getSumOfVector(zOut));
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

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
        bottomTopWeights = new double[Constants.N][Constants.M];
    }

    public void initializeBottomTopWeights() {
        for (int i = 0; i < Constants.N; i++) {
            for (int j = 0; j < Constants.M; j++) {
                bottomTopWeights[i][j] = 1 / (Constants.N + 1);
            }
        }
    }
}

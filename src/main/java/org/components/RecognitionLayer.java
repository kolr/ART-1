package org.components;

import org.Constants;

/**
 * 04.06.2016
 * Created by Rodion.
 */
public class RecognitionLayer {
    private int[] recognitionLayerOutput;
    private double[][] topBottomWeights;

    public RecognitionLayer() {
        recognitionLayerOutput = new int[Constants.M];
        topBottomWeights = new double[Constants.M][Constants.N];
    }

    public void initializeTopBottomWeights() {
        for (int i = 0; i < Constants.M; i++) {
            for (int j = 0; j < Constants.N; j++) {
                this.topBottomWeights[i][j] = (double) 1;
            }
        }
    }

    public void initializeRecognitionLayerOutput() {
        for (int i = 0; i < Constants.M; i++) {
            this.recognitionLayerOutput[i] = 0;
        }
    }

    public double[][] getTopBottomWeights() {
        return this.topBottomWeights;
    }
}

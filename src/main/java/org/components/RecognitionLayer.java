package org.components;

import org.Constants;

/**
 * 04.06.2016
 * Created by Rodion.
 */
public class RecognitionLayer {
    private int[] recognitionLayerOutput;
    private int[][] topBottomWeights;
    private int[] neuronStatus;

    public RecognitionLayer() {
        recognitionLayerOutput = new int[Constants.M];
        topBottomWeights = new int[Constants.M][Constants.N];
        neuronStatus = new int[Constants.M];
        initializeRecognitionLayerOutput();
        initializeTopBottomWeights();
        initializeStatuses();
    }

    public void initializeTopBottomWeights() {
        for (int i = 0; i < Constants.M; i++) {
            for (int j = 0; j < Constants.N; j++) {
                this.topBottomWeights[i][j] = 1;
            }
        }
    }

    public void changeTopBottomWeights(int[] zOut, int cluster) {
        for (int j = 0; j < Constants.N; j++) {
            this.topBottomWeights[cluster][j] = zOut[j];
        }
    }

    public void initializeRecognitionLayerOutput() {
        for (int i = 0; i < Constants.M; i++) {
            this.recognitionLayerOutput[i] = 0;
        }
    }

    public void initializeStatuses() {
        for (int i = 0; i < this.neuronStatus.length; i++) {
            this.neuronStatus[i] = 0;
        }
    }

    public int chooseCluster(double[] input) {
        int cluster = 0;
        for (int i = 1; i < input.length; i++) {
            if (neuronStatus[i] == -1) {
                continue;
            }
            if (input[i] > input[cluster]) {
                cluster = i;
            }
        }
        return cluster;
    }

    public int[] determineComparativeOutput(int[] object, int cluster) {
        int[] result = new int[Constants.N];
        for (int i = 0; i < Constants.N; i++) {
            result[i] = object[i] * topBottomWeights[cluster][i];
        }
        return result;
    }

    public int getStatus(int j) {
        return neuronStatus[j];
    }

    public void setStatus(int j, int status) {
        neuronStatus[j] = status;
    }

    public int[][] getTopBottomWeights() {
        return this.topBottomWeights;
    }

    public int[] getRecognitionLayerOutput() {
        return recognitionLayerOutput;
    }
}

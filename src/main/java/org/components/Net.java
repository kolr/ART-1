package org.components;

import org.Constants;
import org.components.neurons.managing.GOne;
import org.components.neurons.managing.GTwo;

/**
 * 04.06.2016
 * Created by Rodion.
 */
public class Net {
    private ComparativeLayer comparativeLayer;
    private RecognitionLayer recognitionLayer;
    private InputLayer inputLayer;
    private GOne gOne;
    private GTwo gTwo;

    public Net() {
        comparativeLayer = new ComparativeLayer();
        recognitionLayer = new RecognitionLayer();
        inputLayer = new InputLayer();
        gOne = new GOne();
        gTwo = new GTwo();
    }

    public void start(int[] object) {
        inputLayer.setNewObject(object);
        System.out.println("object: ");
        for (int i = 0; i < object.length; i++) {
            System.out.print(object[i] + " ");
        }
        int inputLayerRate = inputLayer.getOutputRate();
        System.out.println("Input Layer Rate: " + inputLayerRate);

        comparativeLayer.initializeBottomTopWeights();
        comparativeLayer.determineComparativeOutput(object);
        double[] in = determineRecognitionLayerInput(comparativeLayer.getComparativeLayerOutput(), comparativeLayer.getBottomTopWeights());
        System.out.println("Recognition Layer Inputs:");
        for (int i = 0; i < Constants.M; i++) {
            System.out.print(in[i] + " ");
        }
    }

    private void sendObjectTo() {

    }

    private double[] determineRecognitionLayerInput(int[] comparativeLayerOutput, double[][] bottomTopWeights) {
        double[] result = new double[Constants.M];
        for (int i = 0; i < Constants.M; i++) {
            result[i] = 0.0;
            for (int j = 0; j < Constants.N; j++) {
                result[i] += (double) bottomTopWeights[i][j] * comparativeLayerOutput[j];
            }
        }
        return result;
    }

}

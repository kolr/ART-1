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
        int gOneValue = gOne.activate(object, recognitionLayer.getRecognitionLayerOutput());
        int gTwoValue = gTwo.activate(object);
        if (gOneValue == 1) {
            comparativeLayer.determineComparativeOutput(object);
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

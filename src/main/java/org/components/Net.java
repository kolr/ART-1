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
    private GOne gOne;
    private GTwo gTwo;

    public Net() {
        comparativeLayer = new ComparativeLayer();
        recognitionLayer = new RecognitionLayer();
        gOne = new GOne();
        gTwo = new GTwo();
    }

    public void start(int[] object) {
        recognitionLayer.initializeStatuses();
        System.out.println("Object");
        for (int i = 0; i < object.length; i++) {
            System.out.print(object[i] + " ");
        }
        int gOneValue = gOne.activate(object, recognitionLayer.getRecognitionLayerOutput());
        int gTwoValue = gTwo.activate(object);
        if (gOneValue == 1) {
            comparativeLayer.determineComparativeOutput(object);
            double[] in = determineRecognitionLayerInput(comparativeLayer.getComparativeLayerOutput(), comparativeLayer.getBottomTopWeights());
            System.out.println("Cluster:" + searchCluster(object, in));
        }
    }

    private int searchCluster(int[] object, double[] in) {

        int appropriateCluster = recognitionLayer.chooseCluster(in);
        int[] comparativeOutput = recognitionLayer.determineComparativeOutput(object, appropriateCluster);
        int similarity = getSumOfVector(comparativeOutput) / getSumOfVector(object);
        System.out.print(" similarity: " + similarity + " ");
        if (similarity < Constants.P) {
            recognitionLayer.setStatus(appropriateCluster, -1);
            return searchCluster(object, in);
        } else {
            comparativeLayer.changeBottomTopWeights(comparativeOutput, appropriateCluster);
            recognitionLayer.changeTopBottomWeights(comparativeOutput, appropriateCluster);
            return appropriateCluster;
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

    public static int getSumOfVector(int[] vector) {
        int res = 0;
        for (int i = 0; i < vector.length; i++) {
            res += vector[i];
        }
        return res;
    }

}

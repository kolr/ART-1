package org.components;

import org.Constants;
import org.components.neurons.managing.GOne;
import org.springframework.context.annotation.ComponentScan;

import javax.inject.Inject;

/**
 * 04.06.2016
 * Created by Rodion.
 */

@ComponentScan
public class Net {
    @Inject
    private ComparativeLayer comparativeLayer;

    @Inject
    private RecognitionLayer recognitionLayer;

    @Inject
    private GOne gOne;

    public void start(int[] object) {
        recognitionLayer.initializeStatuses();
        printWeights(comparativeLayer.getBottomTopWeights());
        System.out.println("Object");
        for (int i = 0; i < object.length; i++) {
            System.out.print(object[i] + " ");
        }
        int gOneValue = gOne.activate(object, recognitionLayer.getRecognitionLayerOutput());
        if (gOneValue == 1) {
            comparativeLayer.determineComparativeOutput(object);
            double[] in = determineRecognitionLayerInput(comparativeLayer.getComparativeLayerOutput(), comparativeLayer.getBottomTopWeights());
            System.out.println("Cluster:" + searchCluster(object, in));
            System.out.println();
        }
    }

    //TODO if all clusters blocked, return 0.
    private int searchCluster(int[] object, double[] in) {
        int appropriateCluster = recognitionLayer.chooseCluster(in);
        int[] comparativeOutput = recognitionLayer.determineComparativeOutput(object, appropriateCluster);
        System.out.println("Comparative output rank: " + getSumOfVector(comparativeOutput));
        System.out.println("Object output rank: " + getSumOfVector(object));
        double similarity = (double) getSumOfVector(comparativeOutput) / getSumOfVector(object);
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

    private double[] determineRecognitionLayerInput(int[] comparativeLayerOutput, double[][] bottomTopWeights) {
        double[] result = new double[Constants.M];
        for (int i = 0; i < Constants.M; i++) {
            result[i] = 0.0;
            for (int j = 0; j < Constants.N; j++) {
                result[i] += bottomTopWeights[i][j] * comparativeLayerOutput[j];
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

    private void printWeights(double[][] weightsMatrix) {
        for (int i = 0; i < Constants.M; i++) {
            for (int j = 0; j < Constants.N; j++) {
                System.out.print(weightsMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

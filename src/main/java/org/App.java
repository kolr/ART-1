package org;

import org.components.ComparativeLayer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ComparativeLayer comparativeLayer = new ComparativeLayer();
        comparativeLayer.initializeBottomTopWeights();
        double[][] weights = comparativeLayer.getBottomTopWeights();
        for (int i = 0; i < Constants.M; i++) {
            for (int j = 0; j < Constants.N; j++) {
                System.out.print(weights[i][j] + " ");
            }
            System.out.println();
        }
    }
}

package org.components.neurons.managing;

/**
 * 04.06.2016
 * Created by Rodion.
 */

/**
 * Neuron-receiver to activate comparative layer if object not empty.
 */
public class GOne {

    private boolean isInhibited(int[] recognitionOutput) {
        for (int i = 0; i < recognitionOutput.length; i++) {
            if (recognitionOutput[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public int activate(int[] object, int[] recognitionOutput) {
        if (!isInhibited(recognitionOutput)) {
            for (int i = 0; i < object.length; i++) {
                if (object[i] == 1) {
                    return 1;
                }
            }
            return 0;
        }
        return 0;
    }
}

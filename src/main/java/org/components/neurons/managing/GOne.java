package org.components.neurons.managing;

/**
 * 04.06.2016
 * Created by Rodion.
 */

/**
 * Neuron-receiver to activate comparative layer if object not empty.
 */
public class GOne {
    private boolean inhibited;

    public boolean isInhibited() {
        return inhibited;
    }

    public void setInhibited(boolean inhibited) {
        this.inhibited = inhibited;
    }

    public int activate(int[] object) {
        if (!inhibited) {
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

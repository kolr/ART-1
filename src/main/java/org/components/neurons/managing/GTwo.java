package org.components.neurons.managing;

/**
 * 04.06.2016
 * Created by Rodion.
 */
public class GTwo {
    public int activate(int[] object) {
        for (int i = 0; i < object.length; i++) {
            if (object[i] == 1) {
                return 1;
            }
        }
        return 0;
    }
}

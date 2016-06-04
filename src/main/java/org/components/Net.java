package org.components;

/**
 * 04.06.2016
 * Created by Rodion.
 */
public class Net {
    private ComparativeLayer comparativeLayer;
    private RecognitionLayer recognitionLayer;
    private InputLayer inputLayer;

    public void start(int[] object) {
        inputLayer.setNewObject(object);
    }

    private void sendObjectTo() {

    }


}

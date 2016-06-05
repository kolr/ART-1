package org.components;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 05.06.2016
 * Created by Rodion.
 */
public class AdditionalLayerTest {

    @Test
    public void checkDetermineNumberOfNeurons() {
        AdditionalLayer additionalLayer = new AdditionalLayer(2);
        assertEquals(6, additionalLayer.getNumberOfNeurons());
    }
}
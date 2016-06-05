package org.components.neurons;

/**
 * 05.06.2016
 * Created by Rodion.
 */
public class AdditionalNeuron {
    private int index;
    private boolean activated;
    private int numberOfInputs;
    private int[] objs;

    public AdditionalNeuron(int index, int numberOfInputs) {
        this.index = index;
        this.numberOfInputs = numberOfInputs;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public int getNumberOfInputs() {
        return numberOfInputs;
    }

    public void setNumberOfInputs(int numberOfInputs) {
        this.numberOfInputs = numberOfInputs;
    }

    public int[] getObjs() {
        return objs;
    }

    public void setObjs(int[] objs) {
        this.objs = objs;
    }
}

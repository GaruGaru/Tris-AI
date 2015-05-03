package com.garu.Game.AI.ANN.Generic;

/**
 * Created by Garu on 03/05/2015.
 */
public class Layer {

    private Neuron[] neurons;

    public Layer(int nn, int nw) {
        this.neurons = new Neuron[nn];
        for (int i = 0; i < nn; i++)
            neurons[i] = new Neuron(nw);
    }

    public float getOutputVal(float[] input) {
        float out = 0;
        for (Neuron n : neurons)
            out += n.getOutputVal(input);
        return out;
    }

    public float[] getOutputArr(float[] input) {
        float[] out = new float[neurons.length];
        for (int i = 0; i < neurons.length; i++)
            out[i] = neurons[i].getOutputVal(input);
        return out;
    }

    public void train(float[] input, float out) {
        for (int i = 0; i < neurons.length; i++)
            neurons[i].train(input, out);
    }

}

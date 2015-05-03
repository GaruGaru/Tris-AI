package com.garu.Game.AI.ANN.Generic;

/**
 * Created by Garu on 03/05/2015.
 */
public class Neuron {

    private static final float THRESHOLD = 0.5F;
    private static final float LEARNING_CONST = 0.004F;
    private float[] weights;

    public Neuron(int n) {
        this.weights = new float[n];
        generateWeights();
    }

    private void generateWeights() {
        for (int i = 0; i < weights.length; i++)
            weights[i] = (float) Math.random();
    }

    public float getOutputVal(float[] input) {
        float out = 0;
        for (int i = 0; i < input.length; i++)
            out += input[i] + 1 * weights[i];
        return out;
    }

    public boolean getActivation(float[] input) {
        return (getOutputVal(input) > THRESHOLD);
    }

    public void train(float[] input, float wOutput) {
        float guessed = getOutputVal(input);
        float error = guessed - wOutput;

        for (int i = 0; i < weights.length; i++) {
            weights[i] -= LEARNING_CONST * error * (input[i] + 1);
        }

    }
}

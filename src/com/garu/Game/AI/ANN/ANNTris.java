package com.garu.Game.AI.ANN;

import com.garu.Game.AI.AITris;
import com.garu.Game.AI.ANN.Generic.Layer;
import com.garu.Game.AI.ANN.Generic.Neuron;

/**
 * Created by Garu on 03/05/2015.
 */
public class ANNTris extends AITris {

    private Layer layerInput;
    private Layer layerOutput;
    private Layer middleLayer;

    public ANNTris(int depth, int seed) {
        super(depth, seed);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        float[] array = new float[matrix.length * matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                array[i * j] = matrix[i][j];


        Neuron input = new Neuron(1);
        for (int i = 0; i < 100000; i++) {
            input.train(new float[]{0}, 1);
        }

        System.out.println(input.getOutputVal(new float[]{1}));

    }

    public int[] test(int[][] matrix) {


        return new int[]{0, 1};
    }

    @Override
    public int[] move(int[][] matrix) {
        return test(matrix);
    }
}

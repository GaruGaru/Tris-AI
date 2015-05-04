package com.garu.Game.AI.Genetics;

import com.garu.Game.AI.Genetics.Utils.MathUtils;

/**
 * Created by Garu on 03/05/2015.
 */
public class Individual {

    public static final int CHROMOSOME_LENGHT = 7;

    // [ Vittoria, Sconfitta, 2miei , 2Avversario, 1Mio, 1Avversario, Centrale]
    public static final int[] STANDARD_CHROMOSOME = new int[]{100, -150, 10, -10, 1, -1, 2};

    private int[] chromosome;
    private int fitness = -1;


    public Individual() {
        this.chromosome = new int[CHROMOSOME_LENGHT];
        this.chromosome = MathUtils.randomIntArray(7, -200, 200);
    }

    public int getFitness() {
        if (fitness == -1)
            fitness = FitnessCalc.getFitness(this);
        return fitness;
    }

    public void selfAlterateChromosome(float rate) {
        for (int i = 0; i < chromosome.length; i++)
            if (Math.random() <= rate)
                chromosome[i] = MathUtils.randomBetween(-200, 200);
    }

    /**
     * Getters / Setters
     */
    public void setChromosomeAt(int pos, int val) {
        this.chromosome[pos] = val;
    }

    public int[] getChromosome() {
        return chromosome;
    }

    public void setChromosome(int[] chromosome) {
        this.chromosome = chromosome;
    }
}

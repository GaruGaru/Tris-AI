package com.garu.Game.AI.Genetics;

import com.garu.Game.AI.Genetics.Utils.MathUtils;

/**
 * Created by Garu on 10/03/2015.
 */
public class EvolutionHelper {

    private static final float MUTATION_RATE = 0.5F;
    private static final double uniformRate = 0.50;

    public static Individual crossHover(Individual ind1, Individual ind2) {
        int[] newChromosome = new int[Individual.CHROMOSOME_LENGHT];
        for (int i = 0; i < Individual.CHROMOSOME_LENGHT; i++) {
            Individual selected = (Math.random() <= uniformRate) ? ind1 : ind2;
            int newVal = selected.getChromosome()[i];
            newChromosome[i] = newVal;
        }

        Individual newIndividual = new Individual();
        newIndividual.setChromosome(newChromosome);
        return newIndividual;
    }


    public static void mutate(Individual individual) {

        individual.selfAlterateChromosome(0.5F);

        for (int i = 0; i < Individual.CHROMOSOME_LENGHT; i++)
            if (Math.random() <= MUTATION_RATE) {
                int[] integers = new int[]{MathUtils.getRandom().nextInt(Individual.CHROMOSOME_LENGHT), MathUtils.getRandom().nextInt(Individual.CHROMOSOME_LENGHT)};
                int pos1 = integers[0];
                int pos2 = integers[1];
                int val1 = individual.getChromosome()[pos1];
                int val2 = individual.getChromosome()[pos2];

                individual.setChromosomeAt(pos1, val2);
                individual.setChromosomeAt(pos2, val1);
            }
    }

    public static Individual tournamentSelection(int size, Population pop) {

        Population tournament = new Population(size);

        for (int i = 0; i < size; i++) {
            int randomId = (int) (Math.random() * pop.getSize());
            tournament.setIndividual(i, pop.getIndividual(randomId));
        }

        return tournament.getFittest();
    }
}
package com.garu.Game.AI.Genetics;


/**
 * Created by Garu on 03/05/2015.
 */

public class Population {

    private int tournamentSize = 10;

    private Individual[] population;

    public Population(int size) {
        this.population = new Individual[size];
        for (int i = 0; i < population.length; i++) {
            this.population[i] = new Individual();
        }

    }

    public void evolve() {
        Population newPopulation = new Population(population.length);

        newPopulation.setIndividual(0, getFittest());
        newPopulation.setIndividual(1,getFittest());

        getIndividual(2).selfAlterateChromosome(0.50F);

        for (int i = 2; i < population.length; i++) {
            Individual ind1 = EvolutionHelper.tournamentSelection(tournamentSize, this);
            Individual ind2 = EvolutionHelper.tournamentSelection(tournamentSize, this);
            Individual crossIndividual = EvolutionHelper.crossHover(ind1, ind2);
            EvolutionHelper.mutate(crossIndividual);

            newPopulation.setIndividual(i, crossIndividual);
        }


        population = newPopulation.population;
    }


    public Individual getFittest() {
        Individual fittest = population[0];
        for (Individual i : population)
            if (i.getFitness() >=+ fittest.getFitness())
                fittest = i;
        return fittest;
    }


    public void setIndividual(int pos, Individual individual) {
        population[pos] = individual;
    }

    public int getSize() {
        return population.length;
    }

    public Individual getIndividual(int pos) {
        return population[pos];
    }


}

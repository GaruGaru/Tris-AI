package com.garu.Game.AI.Genetics;

import com.garu.Game.AI.AIMinMaxEval;
import com.garu.Game.AI.AITris;
import com.garu.Game.AI.Genetics.Utils.IndividualPlayer;
import com.garu.Game.Board;
import com.garu.Game.Utils.MatrixHelper;

import java.util.Arrays;

/**
 * Created by Garu on 03/05/2015.
 */
public class Test {

    public static void main(String[] args) {
        Population population = new Population(1000);

        AITris firstIndividual = new IndividualPlayer(population.getFittest(), 5, 0);

        Board board = new Board(new int[3][3], new AIMinMaxEval(5, 0), firstIndividual);

        for (int i = 0; i < 20000; i++) {

            population.evolve();

            System.out.println("\n\nGeneration " + i);
            System.out.println("Best Chromosome: " + Arrays.toString(population.getFittest().getChromosome()));

            board.setPlayer2(new IndividualPlayer(population.getFittest(), 5, 0));

            board.play();

            System.out.println(MatrixHelper.toString(board.getMatrix()));

            System.out.println("\nOutcome: " + board.getWinner(board.getMatrix()));

            board.reset();
        }


    }
}

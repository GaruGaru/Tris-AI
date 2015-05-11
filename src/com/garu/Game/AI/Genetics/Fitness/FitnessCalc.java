package com.garu.Game.AI.Genetics.Fitness;

import com.garu.Game.AI.AIMinMaxPruning;
import com.garu.Game.AI.AITris;
import com.garu.Game.AI.Genetics.Individual;
import com.garu.Game.AI.Genetics.IndividualPlayerPruning;
import com.garu.Game.Board;

/**
 * Created by Garu on 03/05/2015.
 */
public class FitnessCalc {

    private static final int depth = 3;

    private static AITris AI = new AIMinMaxPruning(depth, 1);

    public static int getFitness(Individual individual) {

        int games = 100;
        float score = games * 10;

        Board board = new Board(new int[3][3], AI, new IndividualPlayerPruning(individual, depth, 1));

        for (int i = 0; i < games; i++) {
            board.play();

            switch (board.getWinner(board.getMatrix())) {
                case 1:
                    score--;
                case 2:
                    score++;
                case 0:
                    score -= 0.5F;
            }
            board.reset();
        }
        return (int) score;
    }
}

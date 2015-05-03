package com.garu.Game.AI.Genetics;

import com.garu.Game.AI.AIMinMaxEval;
import com.garu.Game.AI.AITris;
import com.garu.Game.AI.Genetics.Utils.IndividualPlayer;
import com.garu.Game.Board;

/**
 * Created by Garu on 03/05/2015.
 */
public class FitnessCalc {

    public static int getFitness(Individual individual) {

        int games = 100;
        float score = games * 10;
        int depth = 3;

        Board board = new Board(new int[3][3], new AIMinMaxEval(depth, 1), new IndividualPlayer(individual, depth, 1));
        for (int i = 0; i < games; i++) {
            board.play();
            if (board.hasWon(board.getMatrix(), AITris.PL2))
                score++;
            else if (board.hasWon(board.getMatrix(), AITris.PL1))
                score--;
            else
                score -= 0.25F;
            board.reset();
        }
        return (int) score;
    }
}

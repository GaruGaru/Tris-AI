package com.garu.Game.AI;

import java.util.List;

/**
 * Created by Garu on 27/04/2015.
 */
public class AIMinMaxPruning extends AITris {


    public AIMinMaxPruning(int depth, int seed) {
        super(depth, seed);
    }

    @Override
    public int[] move(int[][] matrix) {
        int[] minmax = minmax(matrix, mySeed, depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{minmax[1], minmax[2]};
    }

    /**
     * First run +inf -inf
     */

    public int[] minmax(int[][] matrix, int player, int depth, int alpha, int beta) {

        int bRow = -1, bColumn = -1;
        int bScore = (player == mySeed) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currScore = 0;

        List<int[]> moves = getMoves(matrix);

        if (depth == 0 || moves.isEmpty()) {
            bScore = evaluate(matrix, mySeed); // or player ?
        } else {
            for (int[] move : moves) {
                matrix[move[0]][move[1]] = player;

                currScore = minmax(matrix, getOpponent(player), depth - 1, alpha, beta)[0];

                if ((player == mySeed && currScore > bScore) || (player != mySeed && currScore < bScore)) {
                    boolean ab = (mySeed == player);
                    bScore = currScore;
                    bRow = move[0];
                    bColumn = move[1];

                    if (ab)
                        alpha = currScore;
                    else
                        beta = currScore;
                }


                matrix[move[0]][move[1]] = EMPTY;
                if (alpha > beta) break;

            }
        }

        return new int[]{bScore, bRow, bColumn};
    }

    private int evaluate(int[][] matrix, int player) {
        int score = 0;

        score += evaluateLine(matrix, player, 0, 0, 0, 1, 0, 2);
        score += evaluateLine(matrix, player, 1, 0, 1, 1, 1, 2);
        score += evaluateLine(matrix, player, 2, 0, 2, 1, 2, 2);
        score += evaluateLine(matrix, player, 0, 0, 1, 0, 2, 0);
        score += evaluateLine(matrix, player, 0, 1, 1, 1, 2, 1);
        score += evaluateLine(matrix, player, 0, 2, 1, 2, 2, 2);
        score += evaluateLine(matrix, player, 0, 0, 1, 1, 2, 2);
        score += evaluateLine(matrix, player, 0, 2, 1, 1, 2, 0);

        return score;
    }


    private int evaluateLine(int[][] matrix, int player, int r1, int c1, int r2, int c2, int r3, int c3) {

        int val = 0;

        int opp = getOpponent(player);
        int oppVal = 0, playerVal = 0;

        if (matrix[r1][c1] == mySeed)
            playerVal++;
        else if (matrix[r1][c1] == opp)
            oppVal++;
        if (matrix[r2][c2] == mySeed)
            playerVal++;
        else if (matrix[r2][c2] == opp)
            oppVal++;
        if (matrix[r3][c3] == mySeed)
            playerVal++;
        else if (matrix[r3][c3] == opp)
            oppVal++;

        if (playerVal == 3)
            val = 100;
        else if (oppVal == 3)
            val = -150;

        if (playerVal == 2) {
            if (!(matrix[r1][c1] == player && matrix[r1][c1] == player)) {
                val = 10;
            }
        } else if (oppVal == 2) {
            if (!(matrix[r1][c1] == opp && matrix[r3][c3] == opp)) {
                val = -10;
            }
        }

        if (playerVal == 1)
            val = 1;
        else if (oppVal == 1)
            val = -1;

        if (matrix[1][1] == player)
            val += 1;

        return val;

    }


}

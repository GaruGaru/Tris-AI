package com.garu.Game.AI;

import com.garu.AI.MatrixHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Garu on 27/04/2015.
 */
public class AIMinMaxEval extends AITris {

    private int depth;

    public AIMinMaxEval(int depth, int mySeed) {
        this.depth = depth;
        this.mySeed = mySeed;
    }

    @Override
    public int[] move(int[][] matrix) {
        int[] minmax = minmax(matrix, mySeed, depth);
        return new int[]{minmax[1], minmax[2]};
    }

    public int[] minmax(int[][] matrix, int player, int depth) {

        int bRow = -1, bColumn = -1;
        int bScore = (player == mySeed) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currScore = 0;

        List<int[]> moves = getMoves(matrix);

        if (depth == 0 || moves.isEmpty()) {
            bScore = evaluate(matrix, mySeed); // or player ?
        } else {
            for (int[] move : moves) {
                matrix[move[0]][move[1]] = player;

                currScore = minmax(matrix, getOpponent(player), depth - 1)[0];

                if ((player == mySeed && currScore > bScore) || (player != mySeed && currScore < bScore)) {
                    bScore = currScore;
                    bRow = move[0];
                    bColumn = move[1];
                }

                matrix[move[0]][move[1]] = EMPTY;

            }
        }

        return new int[]{bScore, bRow, bColumn};
    }

    private int evaluate(int[][] matrix, int player) {
        int score = 0;

        ArrayList<List<int[]>> paths = MatrixHelper.getPaths();
        for (List<int[]> path : paths)
            score += evaluateLine(matrix, player, path);

        return score;
    }

    private int evaluateLine(int[][] matrix, int player, List<int[]> line) {

        int val = 0;

        int opp = getOpponent(player);
        int oppVal = 0, playerVal = 0;

        for (int[] cell : line)
            if (matrix[cell[0]][cell[1]] == player)
                playerVal++;
            else if (matrix[cell[0]][cell[1]] == opp)
                oppVal++;

        if (playerVal == 3)
            val = 100;
        else if (oppVal == 3)
            val = -110;

        if (playerVal == 2) {
            if (!(matrix[line.get(0)[0]][line.get(0)[1]] == player && matrix[line.get(2)[0]][line.get(2)[1]] == player)) {
                val = 10;
            }
        }else if (oppVal == 2) {
            if (!(matrix[line.get(0)[0]][line.get(0)[1]] == opp && matrix[line.get(2)[0]][line.get(2)[1]] == opp)) {
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

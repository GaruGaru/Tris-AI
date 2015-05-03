package com.garu.Game.AI;

import java.util.List;

/**
 * Created by Garu on 27/04/2015.
 */
public class AIMinMax extends AITris {

    private int depth;

    public AIMinMax(int depth, int mySeed) {
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
        // Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
        score += evaluateLine(matrix, player, 0, 0, 0, 1, 0, 2);  // row 0
        score += evaluateLine(matrix, player, 1, 0, 1, 1, 1, 2);  // row 1
        score += evaluateLine(matrix, player, 2, 0, 2, 1, 2, 2);  // row 2
        score += evaluateLine(matrix, player, 0, 0, 1, 0, 2, 0);  // col 0
        score += evaluateLine(matrix, player, 0, 1, 1, 1, 2, 1);  // col 1
        score += evaluateLine(matrix, player, 0, 2, 1, 2, 2, 2);  // col 2
        score += evaluateLine(matrix, player, 0, 0, 1, 1, 2, 2);  // diagonal
        score += evaluateLine(matrix, player, 0, 2, 1, 1, 2, 0);  // alternate diagonal

        if (matrix[1][1] == player) score += 15;

        return score;
    }


    private int evaluateLine(int[][] cells, int player, int row1, int col1, int row2, int col2, int row3, int col3) {
        int score = 0;

        int oppSeed = getOpponent(player);

        if (cells[row1][col1] == player) {
            score = 1;
        } else if (cells[row1][col1] == oppSeed) {
            score = -1;
        }

        // Second cell
        if (cells[row2][col2] == player) {
            if (score == 1) {   // cell1 is mySeed
                score = 10;
            } else if (score == -1) {  // cell1 is oppSeed
                return 0;
            } else {  // cell1 is empty
                score = 1;
            }
        } else if (cells[row2][col2] == oppSeed) {
            if (score == -1) { // cell1 is oppSeed
                score = -10;
            } else if (score == 1) { // cell1 is mySeed
                return 0;
            } else {  // cell1 is empty
                score = -1;
            }
        }

        // Third cell
        if (cells[row3][col3] == player) {
            if (score > 0) {  // cell1 and/or cell2 is mySeed
                score *= 10;
            } else if (score < 0) {  // cell1 and/or cell2 is oppSeed
                return 0;
            } else {  // cell1 and cell2 are empty
                score = 1;
            }
        } else if (cells[row3][col3] == oppSeed) {
            if (score < 0) {  // cell1 and/or cell2 is oppSeed
                score *= 10;
            } else if (score > 1) {  // cell1 and/or cell2 is mySeed
                return 0;
            } else {  // cell1 and cell2 are empty
                score = -1;
            }
        }
        return score;
    }



}

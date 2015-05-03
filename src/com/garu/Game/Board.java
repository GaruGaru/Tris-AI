package com.garu.Game;


import com.garu.Game.AI.AITris;

/**
 * Created by Garu on 03/05/2015.
 */
public class Board {

    private int[][] matrix;
    private AITris player1;
    private AITris player2;

    private boolean turn;


    public Board(int[][] matrix, AITris player1, AITris player2) {
        this.matrix = matrix;
        this.player1 = player1;
        this.player2 = player2;
        this.player1.setSeed(AITris.PL1);
        this.player2.setSeed(AITris.PL2);
        this.turn = true;
    }

    public void step() {
        AITris currentPlayer = (turn) ? player1 : player2;
        int[] move = currentPlayer.move(matrix);
        matrix[move[0]][move[1]] = currentPlayer.getSeed();
        turn = !turn;
    }

    public void play() {
        while (!isGameFinished(matrix))
            step();
    }


    public boolean hasWon(int[][] matrix, int player) {
        return (winningPattern(matrix, player, 0, 0, 0, 1, 0, 2) ||
                winningPattern(matrix, player, 1, 0, 1, 1, 1, 2) ||
                winningPattern(matrix, player, 2, 0, 2, 1, 2, 2) ||
                winningPattern(matrix, player, 0, 0, 1, 0, 2, 0) ||
                winningPattern(matrix, player, 0, 1, 1, 1, 2, 1) ||
                winningPattern(matrix, player, 0, 2, 1, 2, 2, 2) ||
                winningPattern(matrix, player, 0, 0, 1, 1, 2, 2) ||
                winningPattern(matrix, player, 0, 2, 1, 1, 2, 0));
    }

    private boolean winningPattern(int[][] matrix, int player, int r1, int c1, int r2, int c2, int r3, int c3) {
        return (matrix[r1][c1] == player && matrix[r2][c2] == player && matrix[r3][c3] == player);
    }

    private boolean isFull(int[][] matrix) {
        int c = 0;
        for (int x = 0; x < matrix.length; x++)
            for (int y = 0; y < matrix[0].length; y++)
                if (matrix[x][y] != 0)
                    c++;
        return (c == 9);
    }

    private boolean isGameFinished(int[][] matrix) {
        return (hasWon(matrix, AITris.PL1) || hasWon(matrix, AITris.PL2) || isFull(matrix));
    }

    private void reset() {
        for (int x = 0; x < matrix.length; x++)
            for (int y = 0; y < matrix[0].length; y++)
                matrix[x][y] = 0;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}

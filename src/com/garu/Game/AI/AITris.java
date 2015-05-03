package com.garu.Game.AI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Garu on 28/04/2015.
 */
public abstract class AITris {

    public static final int EMPTY = 0;
    public static final int PL1 = 1;
    public static final int PL2 = 2;
    protected  int mySeed;


    public abstract int[] move(int[][] matrix);

    protected int getOpponent(int seed) {
        if (seed == EMPTY) return EMPTY;
        else return (seed == PL1) ? PL2 : PL1;
    }

    protected List<int[]> getMoves(int[][] matrix) {
        List<int[]> moves = new ArrayList<>();
        for (int x = 0; x < matrix.length; x++)
            for (int y = 0; y < matrix[0].length; y++)
                if (matrix[x][y] == EMPTY)
                    moves.add(new int[]{x, y});
        Collections.shuffle(moves);
        return moves;
    }

    public void setSeed(int seed){
        this.mySeed = seed;
    }


    public int getSeed() {
        return mySeed;
    }
}

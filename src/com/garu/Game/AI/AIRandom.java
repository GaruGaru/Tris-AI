package com.garu.Game.AI;

import java.util.List;
import java.util.Random;

/**
 * Created by Garu on 03/05/2015.
 */
public class AIRandom extends AITris {

    public AIRandom(int depth, int seed) {
        super(depth, seed);
    }

    @Override
    public int[] move(int[][] matrix) {
        List<int[]> moves = getMoves(matrix);
        return moves.get(new Random().nextInt(moves.size()));
    }
}

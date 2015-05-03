package com.garu.Game.AI.Genetics.Utils;

import java.util.Random;

/**
 * Created by Garu on 03/05/2015.
 */
public class MathUtils {

    private static Random random;

    public static Random getRandom() {
        if (random == null) random = new Random();
        return random;
    }

    public static int randomBetween(int min, int max) {
        return getRandom().nextInt(max - min) + min;
    }

    public static int[] randomIntArray(int size, int min, int max) {
        int[] out = new int[size];
        for (int i = 0; i < size; i++)
            out[i] = randomBetween(min, max);
        return out;
    }

}

package com.garu.Game.Utils;

/**
 * Created by Garu on 28/04/2015.
 */
public class MatrixHelper {
    public static String toString(int[][] matrix) {
        String str = "";
        for (int y = 0; y < matrix.length; y++) {
            str += ("\n");
            for (int x = 0; x < matrix[0].length; x++)
                str += (matrix[x][y] + " ");
        }
        return str;
    }
}

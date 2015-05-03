package com.garu.Game.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Garu on 28/04/2015.
 */
public class MatrixHelper {

    public static ArrayList<List<int[]>> getPaths() {

        List<int[]> diag1 = new ArrayList<>();
        diag1.add(new int[]{0, 2});
        diag1.add(new int[]{1, 1});
        diag1.add(new int[]{2, 0});

        List<int[]> diag0 = new ArrayList<>();
        diag0.add(new int[]{0, 0});
        diag0.add(new int[]{1, 1});
        diag0.add(new int[]{2, 2});

        List<int[]> row0 = new ArrayList<>();
        row0.add(new int[]{0, 0});
        row0.add(new int[]{0, 1});
        row0.add(new int[]{0, 2});

        List<int[]> row1 = new ArrayList<>();
        row1.add(new int[]{1, 0});
        row1.add(new int[]{1, 1});
        row1.add(new int[]{1, 2});


        List<int[]> row2 = new ArrayList<>();
        row2.add(new int[]{2, 0});
        row2.add(new int[]{2, 1});
        row2.add(new int[]{2, 2});


        List<int[]> col0 = new ArrayList<>();
        col0.add(new int[]{0, 0});
        col0.add(new int[]{1, 0});
        col0.add(new int[]{2, 0});

        List<int[]> col1 = new ArrayList<>();
        col1.add(new int[]{0, 1});
        col1.add(new int[]{1, 1});
        col1.add(new int[]{2, 1});

        List<int[]> col2 = new ArrayList<>();
        col2.add(new int[]{0, 2});
        col2.add(new int[]{1, 2});
        col2.add(new int[]{2, 2});

        ArrayList<List<int[]>> paths = new ArrayList<>();

        paths.add(row0);
        paths.add(row1);
        paths.add(row2);
        paths.add(col0);
        paths.add(col1);
        paths.add(col2);
        paths.add(diag0);
        paths.add(diag1);
        return paths;

    }


    public static String toString(int[][] matrix) {
        String str = "";
        for (int y = 0; y < matrix.length; y++) {
            str += ("\n");
            for (int x = 0; x < matrix[0].length; x++) {
                str += (matrix[x][y] + " ");
            }
        }
        return str;
    }
}

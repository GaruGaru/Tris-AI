package com.garu;

import com.garu.AI.AIMinMax;
import com.garu.AI.AIMinMaxEval;
import com.garu.AI.MatrixHelper;
import com.garu.Game.Board;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Board board = new Board(new int[3][3], new AIMinMax(3, 1), new AIMinMaxEval(3, 2));
        board.play();

        System.out.println(MatrixHelper.toString(board.getMatrix()));


    }


}


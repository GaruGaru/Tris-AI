package com.garu;


import com.garu.Game.AI.AIMinMaxEval;
import com.garu.Game.AI.AIRandom;
import com.garu.Game.Board;
import com.garu.Game.Utils.MatrixHelper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Board board = new Board(new int[3][3], new AIRandom(3, 1), new AIMinMaxEval(3, 2));
        board.play();

        System.out.println(MatrixHelper.toString(board.getMatrix()));


    }


}


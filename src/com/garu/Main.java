package com.garu;


import com.garu.Game.AI.AIMinMax;
import com.garu.Game.AI.AIMinMaxEval;
import com.garu.Game.Board;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int pl1Win = 0;
        int pl2Win = 0;

        int games = 100;


        Board board = new Board(new int[3][3], new AIMinMaxEval(5, 2), new AIMinMax(5, 1));
        for (int i = 0; i < games; i++) {

            board.play();

            if (board.getWinner(board.getMatrix()) == 1)
                pl1Win++;
            else if (board.getWinner(board.getMatrix()) == 2)
                pl2Win++;

            board.reset();
        }

        System.out.println("PL1: " + pl1Win);

        System.out.println("PL2: " + pl2Win);

        System.out.println("Ties: " + (games - (pl1Win + pl2Win)));


    }


}


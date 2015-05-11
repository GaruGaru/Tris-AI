package com.garu.Game.AI;

import com.garu.Game.AI.Genetics.Fitness.FitnessCalc;
import com.garu.Game.AI.Genetics.Individual;

/**
 * Created by Garu on 11/05/2015.
 */
public class FitnessTest {

    public static void main(String[] args){

        long time = System.currentTimeMillis();

        FitnessCalc.getFitness(new Individual());

        System.out.println(System.currentTimeMillis()-time);

    }
}

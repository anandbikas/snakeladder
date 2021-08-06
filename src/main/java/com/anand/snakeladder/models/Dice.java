package com.anand.snakeladder.models;

import java.util.Random;

/**
 * Dice
 */
public class Dice {
    public static int DEFAULT_FACES=6;
    protected int faces;

    protected Random random = new Random();

    public Dice(){
        this(DEFAULT_FACES);
    }

    public Dice(int faces) {
        this.faces = faces;
    }

    public int roll(){
        int diceRoll = random.nextInt(faces)+1;
        System.out.println("Dice rolled to : " + diceRoll);

        return diceRoll;
    }
}

package com.anand.snakeladder.models;

import java.util.Random;

/**
 *
 */
public class Dice {
    public static int DEFAULT_FACES=6;
    private int faces;

    public Dice(){
        this(DEFAULT_FACES);
    }

    public Dice(int faces) {
        this.faces = faces;
    }

    public int roll(){
        return new Random().nextInt(faces)+1;
    }
}

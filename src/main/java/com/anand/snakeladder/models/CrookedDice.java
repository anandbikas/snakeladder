package com.anand.snakeladder.models;

/**
 * Crooked Dice to generate even random number
 */
public class CrookedDice extends Dice{

    public CrookedDice() {
    }

    public CrookedDice(int faces) {
        super(faces);
    }

    public int roll(){
        int diceRoll = 2 * (super.random.nextInt(faces/2)+1) ;
        System.out.println("Dice rolled to : " + diceRoll);

        return diceRoll;
    }
}

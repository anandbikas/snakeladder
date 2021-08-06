package com.anand.snakeladder.model;

import com.anand.snakeladder.models.Dice;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 */
@Test
public class DiceTest {

    private Dice dice;
    int faces;

    @BeforeMethod
    public void setup(){
        faces=6;
        dice =  new Dice(6);
    }

    @Test
    public void validateDiceRollScoreBoundary() {

       for(int i=0; i<10; i++){
           int score = dice.roll();
           Assert.assertTrue(score>0 && score<=faces);
       }
    }

}

package com.anand.snakeladder.model;

import com.anand.snakeladder.models.CrookedDice;
import com.anand.snakeladder.models.Dice;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 */
@Test
public class CrookedDiceTest {

    private Dice dice;
    int faces;

    @BeforeMethod
    public void setup(){
        faces=6;
        dice =  new CrookedDice(6);
    }

    @Test
    public void validateDiceRollScoreBoundary() {

       for(int i=0; i<10; i++){
           int score = dice.roll();
           Assert.assertTrue(score>0 && score<=faces);
       }
    }

    @Test
    public void validateDiceRollScoreEven() {

        for(int i=0; i<10; i++){
            int score = dice.roll();
            Assert.assertEquals(score%2,0);
        }
    }

}

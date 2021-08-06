package com.anand.snakeladder.model;

import com.anand.snakeladder.models.Player;
import com.anand.snakeladder.models.Snake;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static mockit.Deencapsulation.setField;

/**
 *
 */
@Test
public class PlayerTest {

    private Player player;

    @BeforeMethod
    public void setup() {
        player = new Player("Bikas");
    }

    @Test
    public void testPlayerMove() {

        player.move(5);
        Assert.assertEquals(player.getLocation(), 5);
    }
}

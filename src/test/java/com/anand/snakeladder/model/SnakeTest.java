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
public class SnakeTest {

    private Player player;

    @BeforeMethod
    public void setup() {
        player = new Player("Bikas");
    }

    @Test (expectedExceptions = RuntimeException.class)
    public void testSnakeHeadLessThanTailRunTimeException() {

        new Snake(3, 6);
    }

    @Test
    public void testSnakeDevour() {

        setField(player, "location", 98);
        new Snake(98, 56).devour(player);
        Assert.assertEquals(player.getLocation(), 56);
    }

    @Test
    public void testSnakeDevourSnakeOutOfReach() {

        setField(player, "location", 75);
        new Snake(98, 56).devour(player);
        Assert.assertEquals(player.getLocation(), 75);
    }
}

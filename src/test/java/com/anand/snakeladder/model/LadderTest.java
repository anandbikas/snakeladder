package com.anand.snakeladder.model;

import com.anand.snakeladder.models.Ladder;
import com.anand.snakeladder.models.Player;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static mockit.Deencapsulation.setField;

/**
 *
 */
@Test
public class LadderTest {

    private Player player;

    @BeforeMethod
    public void setup() {
        player = new Player("Bikas");
    }

    @Test (expectedExceptions = RuntimeException.class)
    public void testLadderStartGreaterThanEndRunTimeException() {

        new Ladder(6, 3);
    }

    @Test
    public void testLadderEscalate() {

        setField(player, "location", 6);
        new Ladder(6, 42).escalate(player);
        Assert.assertEquals(player.getLocation(), 42);
    }

    @Test
    public void testLadderEscalateLadderOutOfReach() {

        setField(player, "location", 5);
        new Ladder(6, 42).escalate(player);
        Assert.assertEquals(player.getLocation(), 5);
    }
}

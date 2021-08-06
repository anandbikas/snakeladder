package com.anand.snakeladder;

import com.anand.snakeladder.models.Board;
import com.anand.snakeladder.models.Player;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import static mockit.Deencapsulation.getField;

/**
 *
 */
@Test
public class SnakeLadderTest {

    private SnakeLadder snakeLadderGame;
    private SnakeLadder snakeLadderGameWithCrookedDice;
    ExecutorService executor;

    @BeforeMethod
    public void setup(){
        snakeLadderGame =  new SnakeLadder(Arrays.asList("Bikas", "Brian", "Alex", "Sam"),false);
        snakeLadderGameWithCrookedDice =  new SnakeLadder(Arrays.asList("Bikas", "Brian", "Alex", "Sam"),true);
        executor = Executors.newFixedThreadPool(5);
    }

    @Test
    public void testSnakeLadderGameAndValidateFinisher() {

        runWithExecutor(()->snakeLadderGame.play(true));

        List<Player> finishers = getField(snakeLadderGame, "finishers");
        Board board = getField(snakeLadderGame, "board");

        Assert.assertEquals(finishers.get(0).getLocation(),board.getBoardSize());

    }


    @Test
    public void testSnakeLadderGameWithCrookedDiceAndValidateFinisher() {

        runWithExecutor(()->snakeLadderGameWithCrookedDice.play(true));

        List<Player> finishers = getField(snakeLadderGameWithCrookedDice, "finishers");
        Board board = getField(snakeLadderGameWithCrookedDice, "board");

        Assert.assertEquals(finishers.get(0).getLocation(),board.getBoardSize());

    }

    /**
     *
     * @param runnable
     */
    private void runWithExecutor(Runnable runnable){

        Future<?> future = executor.submit(runnable);

        try {
            Object result = future.get(10, TimeUnit.SECONDS);
        } catch (TimeoutException ex) {
            throw new RuntimeException("Game is trapped in loop", ex);
        } catch (InterruptedException ex) {
            throw new RuntimeException("Game interrupted", ex);
        } catch (ExecutionException ex) {
            throw new RuntimeException("Game not executed", ex);
        } finally {
            future.cancel(true);
        }
    }
}

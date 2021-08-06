package com.anand.snakeladder;

import static mockit.Deencapsulation.getField;

import com.anand.snakeladder.models.Board;
import com.anand.snakeladder.models.Snake;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;

/**
 *
 */
@Test
public class GameBoardValidationTest {

    private SnakeLadder snakeLadderGame;

    @BeforeMethod
    public void setup(){
        snakeLadderGame =  new SnakeLadder(Arrays.asList("Bikas", "Brian", "Alex", "Sam"),true);
    }

    @Test
    public void validateCellsCount() {

        Board board = getField(snakeLadderGame, "board");
        Assert.assertEquals(board.getBoardSize(), Board.DEFAULT_CELLS);
    }

    @Test
    public void validateSnakesLaddersCount() {

        Board board = getField(snakeLadderGame, "board");

        Map<Integer, Snake> snakesMap = getField(board, "snakesMap");
        Map<Integer, Snake> laddersMap = getField(board, "laddersMap");

        Assert.assertEquals(snakesMap.size(), Board.DEFAULT_SNAKES);
        Assert.assertEquals(laddersMap.size(), Board.DEFAULT_LADDERS);
    }

    @Test
    public void validateSnakesLaddersLoop() {

        Board board = getField(snakeLadderGame, "board");

        Map<Integer, Snake> snakesMap = getField(board, "snakesMap");
        Map<Integer, Snake> laddersMap = getField(board, "laddersMap");

        for(int snakeHead: snakesMap.keySet()){
            Assert.assertNull(laddersMap.get(snakeHead));
        }

        for(int ladderStart: laddersMap.keySet()){
            Assert.assertNull(snakesMap.get(ladderStart));
        }

    }
}

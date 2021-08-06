package com.anand.snakeladder.models;

import com.anand.snakeladder.factories.LadderFactory;
import com.anand.snakeladder.factories.SnakeFactory;

import java.util.Map;

/**
 * Snake Ladder Board
 */
public class Board {
    public static int DEFAULT_CELLS=100;
    public static int DEFAULT_SNAKES=10;
    public static int DEFAULT_LADDERS=10;

    private int boardSize;
    private Map<Integer, Snake> snakesMap;
    private Map<Integer, Ladder> laddersMap;

    /**
     *
     */
    public Board() {
        this(DEFAULT_CELLS, DEFAULT_SNAKES,DEFAULT_LADDERS, null);
    }

    /**
     *
     * @param dice
     */
    public Board(Dice dice) {
        this(DEFAULT_CELLS, DEFAULT_SNAKES,DEFAULT_LADDERS, dice);
    }

    /**
     *
     * @param cells
     * @param snakeCount
     * @param ladderCount
     * @param dice
     */
    public Board(int cells, int snakeCount, int ladderCount, Dice dice) {
        this.boardSize = cells;
        snakesMap = SnakeFactory.getRandomSnakesMap(boardSize, snakeCount, laddersMap, dice);
        laddersMap = LadderFactory.getRandomLaddersMap(boardSize, ladderCount, snakesMap, dice);
    }

    /**
     *
     * @param player
     * @param score
     * @return Return winning status
     */
    public boolean movePlayer(Player player, int score){

        int newLocation = player.getLocation()+score;

        if(newLocation>boardSize) {
            System.out.printf("Player %s : Move out of board rejected!%n", player);
            return false;
        }

        //Snake-Ladder Operation
        if(snakesMap.containsKey(newLocation)){
            snakesMap.get(newLocation).devour(player);

        } else if(laddersMap.containsKey(newLocation)) {
            laddersMap.get(newLocation).escalate(player);

        } else {
            player.move(newLocation);
            return player.getLocation()==boardSize;
        }

        return false;
    }

    public void display(){
        System.out.println("\n ~~~> Snake and Ladder Board ====");
        System.out.println("Snakes  : " + snakesMap);
        System.out.println("Ladders : " + laddersMap);
    }
}

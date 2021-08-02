package com.anand.snakeladder.models;

import com.anand.snakeladder.factories.LadderFactory;
import com.anand.snakeladder.factories.SnakeFactory;

import java.util.Map;

/**
 *
 */
public class Board {
    public static int DEFAULT_CELLS=100;

    private int boardSize;
    private Map<Integer, Snake> snakesMap;
    private Map<Integer, Ladder> laddersMap;

    public Board() {
        this(DEFAULT_CELLS);
    }

    public Board(int cells) {
        this.boardSize = cells;

        snakesMap = SnakeFactory.getRandomSnakesMap(boardSize);
        laddersMap = LadderFactory.getRandomLaddersMap(boardSize);
    }

    /**
     *
     * @param player
     * @param score
     * @return Return winning status
     */
    public boolean movePlayer(Player player, int score){

        int newLocation = player.getLocation()+score;

        //Snake-Ladder Operation
        if(snakesMap.containsKey(newLocation)){
            newLocation = snakesMap.get(newLocation).operate();
        } else if(laddersMap.containsKey(newLocation)) {
            newLocation = laddersMap.get(newLocation).escalate();
        }

        if(newLocation>boardSize){
            newLocation = player.getLocation();
        }

        player.move(newLocation);
        return newLocation==boardSize;
    }

    public void display(){
        System.out.println("\n ~~~> Snake and Ladder Board ====");
        System.out.println("Snakes  : " + snakesMap);
        System.out.println("Ladders : " + laddersMap);
    }
}

package com.anand.snakeladder.factories;

import com.anand.snakeladder.models.CrookedDice;
import com.anand.snakeladder.models.Dice;
import com.anand.snakeladder.models.Ladder;
import com.anand.snakeladder.models.Snake;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Ladder factory to generate random snakes
 */
public class SnakeFactory {

    /**
     *
     * @param boardSize
     * @param snakeCount
     * @param laddersMap
     * @param dice
     * @return
     */
    public static Map<Integer, Snake> getRandomSnakesMap(int boardSize,
                                                         int snakeCount,
                                                         Map<Integer, Ladder> laddersMap,
                                                         Dice dice) {
        Map<Integer, Snake> snakesMap = new HashMap<>();

        Random randomizer = new Random();
        for(int i=0; i<snakeCount;){

            int head = dice instanceof CrookedDice ? 2 * (randomizer.nextInt(boardSize/2)) : randomizer.nextInt(boardSize);
            int tail = dice instanceof CrookedDice ? 2 * (randomizer.nextInt(boardSize/2)) : randomizer.nextInt(boardSize);

            if(tail>0 && tail<head && head-tail<=boardSize/2){
                if(!snakesMap.containsKey(head) && (laddersMap==null || !laddersMap.containsKey(tail))){
                    snakesMap.put(head, new Snake(head,tail));
                    i++;
                }
            }
        }
        return snakesMap;
    }

}

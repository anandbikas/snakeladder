package com.anand.snakeladder.factories;

import com.anand.snakeladder.models.Ladder;
import com.anand.snakeladder.models.Snake;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Ladder factory to generate random snakes
 */
public class SnakeFactory {

    public static Map<Integer, Snake> getRandomSnakesMap(int boardSize, int snakeCount, Map<Integer, Ladder> laddersMap) {
        Map<Integer, Snake> snakesMap = new HashMap<>();

        Random randomizer = new Random();
        for(int i=0; i<snakeCount;){
            int head =  randomizer.nextInt(boardSize);
            int tail =  randomizer.nextInt(boardSize);

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

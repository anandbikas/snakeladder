package com.anand.snakeladder.factories;

import com.anand.snakeladder.models.Snake;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 */
public class SnakeFactory {

    public static Map<Integer, Snake> getRandomSnakesMap(int boardSize) {
        Map<Integer, Snake> snakesMap = new HashMap<>();

        Random randomizer = new Random();
        for(int i=0; i<10;){
            int head =  randomizer.nextInt(boardSize)+1;
            int tail =  randomizer.nextInt(boardSize)+1;

            if(tail>1 && tail<head && head-tail<=boardSize/2){
                snakesMap.put(head, new Snake(head,tail));
                i++;
            }
        }
        return snakesMap;
    }

}

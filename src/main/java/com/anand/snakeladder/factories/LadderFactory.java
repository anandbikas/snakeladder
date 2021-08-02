package com.anand.snakeladder.factories;

import com.anand.snakeladder.models.Ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 */
public class LadderFactory {

    public static Map<Integer, Ladder> getRandomLaddersMap(int boardSize) {
        Map<Integer, Ladder> laddersMap = new HashMap<>();

        Random randomizer = new Random();
        for(int i=0; i<10;){
            int start =  randomizer.nextInt(boardSize)+1;
            int end =  randomizer.nextInt(boardSize)+1;

            if(start>1 && start<end && end-start<=boardSize/2){
                laddersMap.put(start, new Ladder(start,end));
                i++;
            }
        }
        return laddersMap;
    }

}

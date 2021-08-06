package com.anand.snakeladder.factories;

import com.anand.snakeladder.models.Ladder;
import com.anand.snakeladder.models.Snake;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Ladder factory to generate random ladders
 */
public class LadderFactory {

    /**
     *
     * @param boardSize
     * @return
     */
    public static Map<Integer, Ladder> getRandomLaddersMap(int boardSize, int ladderCount, Map<Integer, Snake> snakesMap) {
        Map<Integer, Ladder> laddersMap = new HashMap<>();

        Random randomizer = new Random();
        for(int i=0; i<ladderCount;){
            int start =  randomizer.nextInt(boardSize);
            int end =  randomizer.nextInt(boardSize);

            if(start>0 && start<end && end-start<=boardSize/2){
                if(!laddersMap.containsKey(start) && (snakesMap==null || !snakesMap.containsKey(start))){
                    laddersMap.put(start, new Ladder(start,end));
                    i++;
                }
            }
        }
        return laddersMap;
    }

}

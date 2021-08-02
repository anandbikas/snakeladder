package com.anand.snakeladder.models;

/**
 *
 */
public class Ladder {

    private int start;
    private int end;

    public Ladder(int start, int end) {
        if(start>=end){
            throw new RuntimeException("Ladder start should be less than end");
        }
        this.start = start;
        this.end = end;
    }

    public int escalate(){
        return end;
    }

    @Override
    public String toString() {
        return String.format("(%d-->%d)", start, end);
    }

}

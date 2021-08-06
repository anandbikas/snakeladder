package com.anand.snakeladder.models;

/**
 * Ladder
 */
public class Ladder {

    private int start;
    private int end;

    /**
     *
     * @param start
     * @param end
     */
    public Ladder(int start, int end) {
        if(start>=end){
            throw new RuntimeException("Ladder start should be less than end");
        }
        this.start = start;
        this.end = end;
    }

    /**
     *
     * @param player
     */
    public void escalate(Player player){
        System.out.println("Ladder : " + this + " escalated up the player : " + player);
        player.move(end);
    }

    @Override
    public String toString() {
        return String.format("(%d-->%d)", start, end);
    }

}

package com.anand.snakeladder.models;

/**
 * Snake
 */
public class Snake {

    private int head;
    private int tail;

    /**
     *
     * @param head
     * @param tail
     */
    public Snake(int head, int tail) {
        if(tail>=head){
            throw new RuntimeException("Snake tail should be less than head");
        }
        this.head = head;
        this.tail = tail;
    }

    /**
     *
     * @param player
     */
    public void devour(Player player){
        if(player.getLocation()==head) {
            System.out.println("Snake : " + this + " devoured down the player : " + player);
            player.move(tail);
        }
    }

    @Override
    public String toString() {
        return String.format("(%d-->%d)", head, tail);
    }

}

package com.anand.snakeladder.models;

/**
 *
 */
public class Snake {

    private int head;
    private int tail;

    public Snake(int head, int tail) {
        if(tail>=head){
            throw new RuntimeException("Snake tail should be less than head");
        }
        this.head = head;
        this.tail = tail;
    }

    public int operate(){
        return tail;
    }

    @Override
    public String toString() {
        return String.format("(%d-->%d)", head, tail);
    }

}

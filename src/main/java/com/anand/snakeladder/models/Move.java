package com.anand.snakeladder.models;

/**
 * Move
 */
public class Move {

    private int from;
    private int to;

    public Move(int from, int to){
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return String.format("(%d-->%d)", from, to);
    }
}

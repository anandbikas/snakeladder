package com.anand.snakeladder.models;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * Player
 */
public class Player {

    private String name;
    private int location;
    private List<Move> moveList = new ArrayList<>();

    /**
     *
     * @param name
     */
    public Player(String name) {
        this.name = name;
        this.location = 0;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getLocation() {
        return location;
    }

    /**
     *
     * @param newLocation
     */
    public void move(int newLocation){

        Move move = new Move(location, newLocation);
        this.location = newLocation;
        moveList.add(move);
        System.out.printf("Player %s : Moved %s%n", name, move);
    }

    /**
     *
     */
    public void showMoves(){
        System.out.println(moveList);
    }

    @Override
    public String toString() {
        return format("%s(%d, Moves=%d)", name, location, moveList.size());
    }
}

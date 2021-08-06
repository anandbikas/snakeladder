package com.anand.snakeladder;

import com.anand.snakeladder.models.Board;
import com.anand.snakeladder.models.CrookedDice;
import com.anand.snakeladder.models.Dice;
import com.anand.snakeladder.models.Player;

import java.util.*;

/**
 * SnakeLadder Game
 */
public class SnakeLadder {

    private Board board;
    private Dice dice;
    private Queue<Player> players;

    private List<Player> finishers;

    /**
     *
     * @param playerNames
     */
    public SnakeLadder(List<String> playerNames) {
        this(playerNames, false);
    }

    /**
     *
     * @param playerNames
     * @param crookedDice
     */
    public SnakeLadder(List<String> playerNames, boolean crookedDice) {

        board = new Board();
        dice = crookedDice ? new CrookedDice() : new Dice();
        players = new LinkedList<>();
        finishers = new ArrayList<>();

        playerNames.forEach(playerName -> players.add(new Player(playerName)));

        board.display();
        System.out.println("\nPlayers : " + players);

    }

    /**
     *
     */
    public void play(){

        Scanner scanner = new Scanner(System.in);
        do {
            Player player = players.remove();

            System.out.printf("%nYour turn %s...",player);
            scanner.nextLine();

            int diceRoll = dice.roll();

            if(board.movePlayer(player, diceRoll)){
                System.out.println(player + " finished. Congratulations!");
                finishers.add(player);
            } else {
                players.add(player);
            }
        } while(players.size()>1);

        finishers.add(players.remove());
    }

    /**
     *
     */
    public void declareWinners(){
        System.out.println("\nGame Over! Player Ranks...");
        System.out.println("\n--------------------------");

        //finishers.forEach(System.out::println);

        finishers.forEach((player -> {
            System.out.println(player);
            player.showMoves();
            System.out.println();
        }));

    }

    /**
     *
     * @param args
     */
    public static void main(String [] args){
        System.out.println();

        List<String> playerNames = Arrays.asList("Bikas", "Brian", "Alex", "Sam");
        SnakeLadder snakeLadderGame = new SnakeLadder(playerNames);

        snakeLadderGame.play();
        snakeLadderGame.declareWinners();
    }
}

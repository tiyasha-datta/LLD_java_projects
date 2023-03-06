package tic_tac_toe.controller;

import tic_tac_toe.model.Game;
import tic_tac_toe.model.GameStatus;
import tic_tac_toe.model.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> playersList) {
        try{
            return Game.getBuilder().setDimension(dimension).setPlayerList(playersList).build();
        }
        catch(Exception e){
            System.out.println("Caught an exception");
            e.printStackTrace();
            return null;
        }
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public void executeNextMove(Game game){
        game.makeNextMove();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}

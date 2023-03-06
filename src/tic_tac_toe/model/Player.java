package tic_tac_toe.model;

import java.util.Scanner;

public class Player {

    private String playerName;
    private char playerSymbol;
    private PlayerType playerType;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Player(String playerName, char playerSymbol, PlayerType playerType) {
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
        this.playerType = playerType;
    }

    public Move decideMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row");
        int row = sc.nextInt();

        System.out.println("Enter the column");
        int col = sc.nextInt();

        return new Move(this, new Cell(row, col));
    }
}

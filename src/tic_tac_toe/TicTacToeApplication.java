package tic_tac_toe;

import tic_tac_toe.controller.GameController;
import tic_tac_toe.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the dimensions of the board");
        int dimension = sc.nextInt();

        GameController gameController = new GameController();

        System.out.println("Will there be any BOT in the game : Y / N");
        String isBotString = sc.next();

        List<Player> playersList = new ArrayList<>();
        int toIterate = dimension - 1;

        if(isBotString.equalsIgnoreCase("Y")){
            toIterate = dimension - 2;
        }

        for (int i = 0; i < toIterate; i++) {
            System.out.println("Enter the name of the player");
            String playerName = sc.next();

            System.out.println("Enter the symbol of the player");
            String playerSymbol = sc.next();

            playersList.add(new Player(playerName, playerSymbol.charAt(0), PlayerType.HUMAN));
        }

        if(isBotString.equalsIgnoreCase("Y")){
            System.out.println("Enter the name of the BOT");
            String playerName = sc.next();

            System.out.println("Enter the symbol of the BOT");
            String playerSymbol = sc.next();

            playersList.add(new Bot(playerName, playerSymbol.charAt(0), BotDifficultyLevel.EASY));
        }

        Game game = gameController.createGame(dimension, playersList);

        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            System.out.println("This is the current board");
            gameController.displayBoard(game);

            System.out.println("Does anyone wants to UNDO? Y / N");
            String undoInput = sc.next();

            if(undoInput.equalsIgnoreCase("Y")){
                game.undo();
            }else{
                game.makeNextMove();
            }
        }

        System.out.println("Game has ended, result is : " + game.getGameStatus());
        if(game.getGameStatus().equals(GameStatus.ENDED)){
            System.out.println("Winner is : " + game.getWinner().getPlayerName());
        }



    }
}

package tic_tac_toe.model;

import tic_tac_toe.exception.InvalidGameCreationParametersException;
import tic_tac_toe.strategy.EfficientGameWinningStrategy;
import tic_tac_toe.strategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    
    private Board board;
    private List<Player> playerList;
    private List<Move> moveList;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private GameWinningStrategy gameWinningStrategy;
    private Player winner;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void undo() {
    }

    public void makeNextMove() {

        Player toMovePlayer = playerList.get(nextPlayerIndex);
        System.out.println(toMovePlayer.getPlayerName() + "'s move");
        Move move = toMovePlayer.decideMove(this.board);

        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        System.out.println("Move happened : row -> " + row + ", col -> " + col);
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(toMovePlayer);

        Move playedMove = new Move(toMovePlayer, board.getBoard().get(row).get(col));
        this.moveList.add(playedMove);

        if(gameWinningStrategy.updateBoardAndCheckWinner(board, toMovePlayer, playedMove)){
            gameStatus = GameStatus.ENDED;
            winner = toMovePlayer;
        }
        nextPlayerIndex++;
        nextPlayerIndex %= playerList.size();
    }

    public void displayBoard(){
        this.board.display();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{

        private int dimension;
        private List<Player> playerList;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        private boolean valid() throws InvalidGameCreationParametersException{
            if(this.dimension < 3){
                throw new InvalidGameCreationParametersException("dimensions should be greater than or equal to 3");
            }

            if(this.playerList.size() != dimension -1){
                throw new InvalidGameCreationParametersException("players should be equal to dimension -1");
            }
            return true;
        }

        public Game build() throws InvalidGameCreationParametersException{
            try{
                valid();
            }catch(Exception e){
                throw new InvalidGameCreationParametersException("game could not be created");
            }

            Game game = new Game();
            game.setBoard(new Board(dimension));
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setGameWinningStrategy(new EfficientGameWinningStrategy(dimension));
            game.setMoveList(new ArrayList<>());
            game.setPlayerList(playerList);
            game.setNextPlayerIndex(0);

            return game;
        }
    }
}

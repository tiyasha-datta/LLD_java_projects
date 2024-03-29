package tic_tac_toe.strategy;

import tic_tac_toe.model.Board;
import tic_tac_toe.model.Move;
import tic_tac_toe.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EfficientGameWinningStrategy implements GameWinningStrategy {

    List<HashMap<Character, Integer>> rowSymbolCount = new ArrayList<>();
    List<HashMap<Character, Integer>> colSymbolCount = new ArrayList<>();
    HashMap<Character, Integer> topLeftDiagonalCount = new HashMap<>();
    HashMap<Character, Integer> bottomLeftDiagonalCount = new HashMap<>();
    int dimension;

    public EfficientGameWinningStrategy(int dimension) {

        for (int i = 0; i < dimension; i++) {
            rowSymbolCount.add(new HashMap<>());
            colSymbolCount.add(new HashMap<>());
        }
        this.dimension = dimension;
    }

    public boolean isTopLeftDiag(int row, int col){
        return row == col;
    }

    public boolean isBottomLeftDiag(int row, int col){
        return row + col == dimension - 1;
    }

    @Override
    public boolean updateBoardAndCheckWinner(Board board, Player lastPlayerMove, Move lastMove) {
        char symbol = lastPlayerMove.getPlayerSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getColumn();

        rowSymbolCount.get(row).put(symbol, rowSymbolCount.get(row).getOrDefault(symbol,0) + 1);
        colSymbolCount.get(col).put(symbol, colSymbolCount.get(col).getOrDefault(symbol,0) + 1);

        if(isTopLeftDiag(row, col)){
            topLeftDiagonalCount.put(symbol, topLeftDiagonalCount.getOrDefault(symbol,0) + 1);
        }

        if(isBottomLeftDiag(row, col)){
            bottomLeftDiagonalCount.put(symbol, bottomLeftDiagonalCount.getOrDefault(symbol,0) + 1);
        }

        return checkWinnerLogic(row, col, symbol);
    }

    public boolean checkWinnerLogic(int row, int col, char symbol){
        if(rowSymbolCount.get(row).get(symbol) == dimension){
            return true;
        }

        if(colSymbolCount.get(col).get(symbol) == dimension){
            return true;
        }

        if(isTopLeftDiag(row, col)){
            if(topLeftDiagonalCount.get(symbol) == dimension){
                return true;
            }
        }

        if(isBottomLeftDiag(row, col)){
            if(bottomLeftDiagonalCount.get(symbol) == dimension){
                return true;
            }
        }
        return false;
    }
}

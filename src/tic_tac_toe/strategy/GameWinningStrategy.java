package tic_tac_toe.strategy;

import tic_tac_toe.model.Board;
import tic_tac_toe.model.Move;
import tic_tac_toe.model.Player;

public interface GameWinningStrategy {

    boolean updateBoardAndCheckWinner(Board board, Player lastPlayerMove, Move lastMove);
}

package tic_tac_toe.factory;

import tic_tac_toe.model.BotDifficultyLevel;
import tic_tac_toe.strategy.BotPlayingStrategy;
import tic_tac_toe.strategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        return new RandomBotPlayingStrategy();
    }
}

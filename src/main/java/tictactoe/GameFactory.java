/*
 * Copyright (c) 2019.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package tictactoe;

import tictactoe.component.*;
import tictactoe.component.config.CommandLineArgumentParser;
import tictactoe.component.swing.GameWindow;
import tictactoe.model.config.Level;
import tictactoe.model.config.PlayerType;
import tictactoe.model.game.Player;

import static tictactoe.model.config.PlayerType.USER;
import static tictactoe.model.game.Sign.O;
import static tictactoe.model.game.Sign.X;

/**
 * @author Karl
 * @link <a href="https://babayan.keenetic.link/">https://babayan.keenetic.link</a>
 */
public class GameFactory {
    private final PlayerType player1Type;
    private final PlayerType player2Type;

    private final Level level;


    public GameFactory(final String[] args) {
        final CommandLineArgumentParser.CommandLineArguments commandLineArguments = new CommandLineArgumentParser(args).parse();
        player1Type = commandLineArguments.getPlayer1Type();
        player2Type = commandLineArguments.getPlayer2Type();
        level = commandLineArguments.getLevel();
    }

    public Game create() {
        final GameWindow gameWindow = new GameWindow();
        final Player player1;
        if (player1Type == USER) {
            player1 = new Player(X, new UserMove(gameWindow, gameWindow));
        } else {
            player1 = new Player(X, new ComputerMove(level.getStrategies()));
        }
        final Player player2;
        if (player2Type == USER) {
            player2 = new Player(O, new UserMove(gameWindow, gameWindow));
        } else {
            player2 = new Player(O, new ComputerMove(level.getStrategies()));
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                gameWindow,
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                canSecondPlayerMakeFirstMove);
    }
}

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

package academy.devonline.gomoku.component;


import academy.devonline.gomoku.model.game.GameTable;
import academy.devonline.gomoku.model.game.Player;

import java.util.Random;

/**
 * @author Karl
 * @link <a href="https://babayan.keenetic.link/">https://babayan.keenetic.link</a>
 */
public class Game {

    private final int size;

    private final DataPrinter dataPrinter;

    private final Player player1;

    private final Player player2;

    private final WinnerVerifier winnerVerifier;

    private final CellVerifier cellVerifier;

    private final boolean canSecondPlayerMakeFirstMove;

    public Game(final int size,
                final DataPrinter dataPrinter,
                final Player player1,
                final Player player2,
                final WinnerVerifier winnerVerifier,
                final CellVerifier cellVerifier,
                final boolean canSecondPlayerMakeFirstMove) {
        this.size = size;
        this.dataPrinter = dataPrinter;
        this.player1 = player1;
        this.player2 = player2;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
        this.canSecondPlayerMakeFirstMove = canSecondPlayerMakeFirstMove;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void play() {
        dataPrinter.printInstructions();
        while (true) {
            playNewGame();
        }
    }

    private void playNewGame() {
        final GameTable gameTable = new GameTable(size);
        dataPrinter.printGameTable(gameTable);
        if (canSecondPlayerMakeFirstMove && new Random().nextBoolean()) {
            player2.makeMove(gameTable);
            dataPrinter.printGameTable(gameTable);
        }

        final Player[] players = {player1, player2};

        while (true) {
            for (final Player player : players) {
                player.makeMove(gameTable);
                dataPrinter.printGameTable(gameTable);

                if (winnerVerifier.isWinner(gameTable, player)) {
                    dataPrinter.printInfoMessage(player + " WIN!");
                    return;
                }
                if (cellVerifier.allCellsFilled(gameTable)) {
                    dataPrinter.printInfoMessage("Sorry, DRAW!");
                    return;
                }
            }
        }
    }
}

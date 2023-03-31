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

import academy.devonline.gomoku.model.game.Cell;
import academy.devonline.gomoku.model.game.GameTable;
import academy.devonline.gomoku.model.game.Player;
import academy.devonline.gomoku.model.game.Sign;

import static academy.devonline.gomoku.Constants.GAME_TABLE_SIZE;
import static academy.devonline.gomoku.Constants.WIN_COMBINATION_SIZE;

/**
 * @author Karl
 * @link <a href="https://babayan.keenetic.link/">https://babayan.keenetic.link</a>
 */
public class WinnerVerifier {

    public boolean isWinner(final GameTable gameTable, final Player player) {
        return isWinnerByRows(gameTable, player.getSing()) ||
                isWinnerByCols(gameTable, player.getSing()) ||
                isWinnerByMainDiagonal(gameTable, player.getSing()) ||
                isWinnerBySecondaryDiagonal(gameTable, player.getSing());
    }

    private boolean isWinnerByRows(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < WIN_COMBINATION_SIZE; i++) {
            if (gameTable.getSign(new Cell(i, 0)) == gameTable.getSign(new Cell(i, 1)) &&
                    gameTable.getSign(new Cell(i, 1)) == gameTable.getSign(new Cell(i, 2)) &&
                    gameTable.getSign(new Cell(i, 2)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByCols(final GameTable gameTable, final Sign sign) {
        for (int i = 0; i < WIN_COMBINATION_SIZE; i++) {
            if (gameTable.getSign(new Cell(0, i)) == gameTable.getSign(new Cell(1, i)) &&
                    gameTable.getSign(new Cell(1, i)) == gameTable.getSign(new Cell(2, i)) &&
                    gameTable.getSign(new Cell(2, i)) == sign) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinnerByMainDiagonal(final GameTable gameTable, final Sign sign) {
        return gameTable.getSign(new Cell(0, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(2, 2)) &&
                gameTable.getSign(new Cell(2, 2)) == sign;
    }

    private boolean isWinnerBySecondaryDiagonal(final GameTable gameTable, final Sign sign) {
        return gameTable.getSign(new Cell(2, 0)) == gameTable.getSign(new Cell(1, 1)) &&
                gameTable.getSign(new Cell(1, 1)) == gameTable.getSign(new Cell(0, 2)) &&
                gameTable.getSign(new Cell(0, 2)) == sign;
    }

    private boolean isWinnerUsingLambda(final GameTable gameTable, final Sign sign, final Lambda lambda) {
        for (int i = 0; i < GAME_TABLE_SIZE; i++) {
            for (int j = 0; j < GAME_TABLE_SIZE; j++) {
                int filledCellCount = 0;
                for (int k = 0; k < WIN_COMBINATION_SIZE; k++) {
                    final Cell cell = lambda.convert(i, j, k);
                    if (gameTable.isValid(cell)) {
                        if (gameTable.getSign(cell) == sign) {
                            filledCellCount++;
                        } else {
                            break;
                        }
                    }
                }
                if (filledCellCount == WIN_COMBINATION_SIZE) {
                    return true;
                }
            }
        }
        return false;
    }

    @FunctionalInterface
    private interface Lambda {
        Cell convert(int i, int j, int k);
    }
}
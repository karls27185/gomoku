package academy.devonline.gomoku;

import academy.devonline.gomoku.model.config.Level;
import academy.devonline.gomoku.model.config.Size;

import static academy.devonline.gomoku.model.config.Level.LEVEL2;
import static academy.devonline.gomoku.model.config.Size.SIZE15;

/**
 * @author Karl
 * @link <a href="https://babayan.keenetic.link/">https://babayan.keenetic.link</a>
 */
public final class Constants {

    public static final int WIN_COMBINATION_SIZE = 5;

    public static final String DELAY_PREFIX = "DELAY=";

    public static final Level DEFAULT_LEVEL = LEVEL2;

    public static final Size DEFAULT_SIZE = SIZE15;

    public static final long DEFAULT_DELAY_IN_MILLIS = 0;

    public Constants() {
    }
}

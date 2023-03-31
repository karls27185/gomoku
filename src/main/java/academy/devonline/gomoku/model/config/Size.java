package academy.devonline.gomoku.model.config;

/**
 * @author Karl
 * @link <a href="https://babayan.keenetic.link/">https://babayan.keenetic.link</a>
 */
public enum Size {

    SIZE7,

    SIZE8,

    SIZE9,

    SIZE10,

    SIZE11,

    SIZE12,

    SIZE13,

    SIZE14,

    SIZE15;

    public int intValue(){
        return Integer.parseInt(name().substring(4));
    }
}

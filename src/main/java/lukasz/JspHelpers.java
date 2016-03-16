package lukasz;

/**
 * Created by LouL on 16.03.2016.
 */
public class JspHelpers {
    public static String emptyIfNull(String text) {
        return text == null ? "" : text;
    }
}

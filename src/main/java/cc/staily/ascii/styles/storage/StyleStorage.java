package cc.staily.ascii.styles.storage;

import cc.staily.ascii.styles.Style;

import java.util.ArrayList;

public class StyleStorage {
    private static final ArrayList<Style> _styles = new ArrayList<>();

    public static void registerStyle(Style style) {
        _styles.add(style);
    }

    public static ArrayList<Style> getStyles() {
        return _styles;
    }

    public static Style getStyle(int index) {
        return _styles.get(index);
    }
}

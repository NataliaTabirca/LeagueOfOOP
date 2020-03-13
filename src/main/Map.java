package main;

import java.util.ArrayList;

public final class Map {
    private static Map instance = null;
    private ArrayList<String> map;

    private Map(final ArrayList<String> map) {
        this.map = map;
    }

    public static Map getInstance(final ArrayList<String> value) {
        if (instance == null) {
            instance = new Map(value);
        }
        return instance;
    }

    public static Map getInstance() {
        return instance;
    }

    public ArrayList<String> getMap() {
        return map;
    }
}

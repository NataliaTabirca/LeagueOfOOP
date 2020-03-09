package main;

import java.util.ArrayList;

public final class Moves {
    private static Moves instance = null;
    private ArrayList<String> map;

    private Moves(final ArrayList<String> map) {
        this.map = map;
    }

    public static Moves getInstance(final ArrayList<String> value) {
        if (instance == null) {
            instance = new Moves(value);
        }
        return instance;
    }

    public static Moves getInstance() {
        return instance;
    }

    public ArrayList<String> getMoves() {
        return map;
    }
}

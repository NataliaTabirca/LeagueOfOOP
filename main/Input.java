package main;

import java.util.ArrayList;

public final class Input {
    private final ArrayList<String> map;
    private final ArrayList<String> heros;
    private final ArrayList<Integer> x, y;
    private final ArrayList<String> moves;

     Input(final ArrayList<String> map, final ArrayList<String> heros, final ArrayList<Integer> x,
           final ArrayList<Integer> y, final ArrayList<String> moves) {
        this.map = map;
        this.heros = heros;
        this.x = x;
        this.y = y;
        this.moves = moves;
    }

    public ArrayList<String> getMap() {
        return map;
    }
    public ArrayList<String> getHeros() {
        return heros;
    }
    public ArrayList<Integer> getX() {
        return x;
    }
    public ArrayList<Integer> getY() {
        return y;
    }
    public ArrayList<String> getMoves() {
        return moves;
    }
}

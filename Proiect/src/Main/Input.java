package Main;

import java.util.ArrayList;

public class Input {
    private final int N, M;
    private final ArrayList<String> map;
    private final int P;
    private final ArrayList<String> heros;
    private final ArrayList<Integer> x, y;
    private final int rounds;
    private final ArrayList<String> moves;

     Input(int n, int m, ArrayList<String> map, int p, ArrayList<String> heros, ArrayList<Integer> x, ArrayList<Integer> y, int rounds, ArrayList<String> moves) {
        N = n;
        M = m;
        this.map = map;
        P = p;
        this.heros = heros;
        this.x = x;
        this.y = y;
        this.rounds = rounds;
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

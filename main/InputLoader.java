package main;

import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;

public final class InputLoader {
    private final String input;
    private final String output;

    public InputLoader(final String input, final String output) {
        this.input = input;
        this.output = output;
    }

    public Input load() {
        ArrayList<String> map = new ArrayList<>();
        ArrayList<String> heros = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        ArrayList<String> moves = new ArrayList<>();
        int n = 0, m = 0, p = 0, rounds = 0;
        try {
            FileSystem fs = new FileSystem(input, output);

            n = fs.nextInt();
            m = fs.nextInt();
            for (int i = 0; i < n; i++) {
                map.add(fs.nextWord());
            }
            p = fs.nextInt();
            for (int i = 0; i < p; i++) {
                heros.add(fs.nextWord());
                x.add(fs.nextInt());
                y.add(fs.nextInt());
            }
            rounds = fs.nextInt();
            for (int i = 0; i < rounds; i++) {
                moves.add(fs.nextWord());
            }
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Input(map, heros, x, y, moves);
    }
}

package Main;

import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;

public class InputLoader {
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
        int N = 0, M = 0, P = 0, rounds = 0;
        try {
            FileSystem fs = new FileSystem(input, output);

            N = fs.nextInt();
            M = fs.nextInt();
            for (int i = 0; i < N; i++) {
                map.add(fs.nextWord());
            }
            P = fs.nextInt();
            for (int i = 0; i < P; i++) {
                heros.add(fs.nextWord());
                x.add(fs.nextInt());
                y.add(fs.nextInt());
            }
            rounds = fs.nextInt();
            for (int i = 0; i < rounds; i++) {
                moves.add(fs.nextWord());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Input(N, M, map, P, heros, x, y, rounds, moves);
    }
}

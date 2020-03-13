package main;

import angels.Angel;
import angels.AngelFactory;
import angels.AngelsInRound;
import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;

public final class InputLoader {
    private final String input;
    private final String output;
    private final int three = 3;
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
        ArrayList<AngelsInRound> auxAngels = new ArrayList<>();
        int n, p;
        try {
            FileSystem fs = new FileSystem(input, output);

            n = fs.nextInt();
            fs.nextInt();
            for (int i = 0; i < n; i++) {
                map.add(fs.nextWord());
            }
            p = fs.nextInt();
            for (int i = 0; i < p; i++) {
                heros.add(fs.nextWord());
                x.add(fs.nextInt());
                y.add(fs.nextInt());
            }
            int rounds = fs.nextInt();
            for (int i = 0; i < rounds; i++) {
                moves.add(fs.nextWord());
            }

            ArrayList<Integer> nrAngels = new ArrayList<>(); // read the number of angels in rounds
            ArrayList<ArrayList<String>> angelsPerRounds = new ArrayList<>();   // and the angels
            for (int i = 0; i < rounds; i++) {
               nrAngels.add(fs.nextInt());
               ArrayList<String> temp = new ArrayList<>();
               if (nrAngels.get(i) == 0) {
                   temp.add(null);
               } else {
                   int aux = nrAngels.get(i);
                   while (aux != 0) {
                       temp.add(fs.nextWord());
                       aux--;
                   }
               }
               angelsPerRounds.add(temp);   // store an array of ints and Array of String
            }
            for (int i = 0; i < rounds; i++) {
                int aux = 0;
                ArrayList<Angel> temporary = new ArrayList<>();
                while (aux != nrAngels.get(i)) {
                    String[] temp = angelsPerRounds.get(i).get(aux).split(",", three);  // get name
                                                                                      // and coords
                    temporary.add(AngelFactory.createAngel(temp[0],
                            Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
                    aux++;
                }
                if (nrAngels.get(i) != 0) {
                    auxAngels.add(new AngelsInRound(nrAngels.get(i), temporary));
                } else {
                    auxAngels.add(new AngelsInRound(nrAngels.get(i)));
                }
            }

            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Input(map, heros, x, y, moves, auxAngels);
    }
}

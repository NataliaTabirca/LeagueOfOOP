package main;

import angels.AllAngels;
import hero.AllHeroes;
import hero.HeroFactory;
import fileio.FileSystem;
import java.io.IOException;
import java.util.ArrayList;

public final class Main {
    private Main() { }
    public static void main(final String[] args) throws IOException {
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input input = inputLoader.load();  // get the data about the game

        ArrayList<String> hero = input.getHeros();
        ArrayList<Integer> xCoord = input.getX(),  yCoord = input.getY();
        Map.getInstance(input.getMap());
        Moves.getInstance(input.getMoves());

        for (int i = 0; i < hero.size(); i++) {  // add the heroes
            AllHeroes.getInstance().getHeroes().add(HeroFactory.createHero(hero.get(i),
                    xCoord.get(i), yCoord.get(i)));
        }
        FileSystem fs = new FileSystem(args[0], args[1]);
        AllAngels.getInstance(input.getAuxAngels());
        AllHeroes.getInstance().asignIndex();
        for (int i = 0; i < Moves.getInstance().getMoves().size(); i++) {
            System.out.println("Runda " + (i + 1));
            try {
                if (i != 0) {
                    fs.writeNewLine();
                }
                fs.writeWord("~~ Round " + (i + 1) + " ~~");
                fs.writeNewLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AllHeroes.getInstance().startFight(i, fs);
            AllHeroes.getInstance().spawnAngels(i, fs);
            System.out.println("-------------------");
        }
        fs.writeNewLine();
        AllHeroes.getInstance().endOfGame(fs);
    }
}

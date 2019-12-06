package main;

import hero.AllHeroes;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

import java.util.ArrayList;

public final class Main {
    private Main() { }
    public static void main(final String[] args) {
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input input = inputLoader.load();  // get the data about the game
        ArrayList<String> map = input.getMap();
        ArrayList<String> hero = input.getHeros();
        ArrayList<Integer> xCoord = input.getX();
        ArrayList<Integer> yCoord = input.getY();
        ArrayList<String> moves = input.getMoves();
        AllHeroes heroes = new AllHeroes();
        int nrPlayers = hero.size();  // store the number of the heroes
        for (int i = 0; i < nrPlayers; i++) {  // add the heroes
            int x = xCoord.get(i);
            int y = yCoord.get(i);
            char m = map.get(x).charAt(y);
            switch (hero.get(i)) {
                case "K":
                    heroes.getHeroes().add(new Knight(x, y, m));
                    break;
                case "P":
                    heroes.getHeroes().add(new Pyromancer(x, y, m));
                    break;
                case "R":
                    heroes.getHeroes().add(new Rogue(x, y, m));
                    break;
                case "W":
                    heroes.getHeroes().add(new Wizard(x, y, m));
                    break;
                default:
                    break;
            }
        }
        int rounds = moves.size();
        for (int i = 0; i < rounds; i++) {
            heroes.startFight(i, moves, map);
        }
        heroes.endOfGame(args[0], args[1]);
    }
}

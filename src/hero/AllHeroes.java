package hero;

import angels.AllAngels;
import angels.Angel;
import fileio.FileSystem;
import main.Map;
import main.Moves;
import constants.Constants;
import java.io.IOException;
import java.util.ArrayList;

public final class AllHeroes {
    private static AllHeroes instance = null;
    private ArrayList<Hero> heroes;

    private AllHeroes() {
        this.heroes = new ArrayList<>();
    }

    public static AllHeroes getInstance() {
        if (instance == null) {
            instance = new AllHeroes();
        }
        return instance;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void asignIndex() {
        for (int i = 0; i < getHeroes().size(); i++) {
            getHeroes().get(i).setIndex(i);
        }
    }

    public int findOponent(final Hero hero) {
        int poz = -1;
        for (int i = 0; i < getHeroes().size(); i++) {
            if (hero == getHeroes().get(i)) {
                poz = i;
                break;
            }
        }
        if (hero.getHp() > 0) {
            for (int i = poz + 1; i < getHeroes().size(); i++) {
                if (hero.samePlace(getHeroes().get(i)) && getHeroes().get(i).getHp() > 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void moveHeroes(final int round) {
        for (int i = 0; i < getHeroes().size(); i++) {
            Hero h = getHeroes().get(i);
            if (h.getRoundsReceiveOTD() == 0) {
                h.setMove(true);
            }
            if (h.canMove() && h.getHp() > 0) {
                switch (Moves.getInstance().getMoves().get(round).charAt(i)) {
                    case 'R':
                        h.setY(h.getY() + 1);
                        break;
                    case 'L':
                        h.setY(h.getY() - 1);
                        break;
                    case 'D':
                        h.setX(h.getX() + 1);
                        break;
                    case 'U':
                        h.setX(h.getX() - 1);
                        break;
                    default:
                        break;
                }
                if (h.getX() >= 0 && h.getY() >= 0) {
                    h.setMap(Map.getInstance().getMap().get(h.getX()).charAt(h.getY()));
                }
            }
        }
    }

    private void applyOvertimeDamage(final int round) {
        for (Hero h : getHeroes()) {
            if (h.isAlive()) {
                if (h.getRoundsReceiveOTD() > 0) {
                    h.applyOTD(round);
                }
            }
        }
    }

    public void startFight(final int round, final FileSystem fs) {
        moveHeroes(round);          // move the heroes on the map
        applyOvertimeDamage(round); // apply the overtime damage
//        System.out.println("Inainte de lupta:");
//        for (Hero h : getHeroes()) {
//            System.out.println(h.getType() + " " + h.getHp());
//        }
        for (int i = 0; i < getHeroes().size(); i++) {
            Hero h1 = getHeroes().get(i);
            int index = findOponent(h1);    // find the heroes that are in a fight
            if (index != -1) {
                Hero h2 = getHeroes().get(index);
                if (h1.canMove()) {         // if player is not disabled
                    h1.chooseStrategy();    // choose strategy
                }
                if (h2.canMove()) {         // same here
                    h2.chooseStrategy();
                }
                if (h1.isAlive() && h2.isAlive()) { // if the both are alive
                    h1.fightOpponent(h2, round);    // h2 atacks h1
                    h2.fightOpponent(h1, round);    // h1 atacks h2
                    if (h2.getHp() <= 0) {          // h2 is dead
                        h1.notifyObserver(fs, h2);  // notify the Great Magician
                        h2.setHp(0);
                        h2.setAlive(false);
                        if (h1.getHp() > 0) {       // if h1 is still alive
                            int max = Math.max(Constants.MAX_XP_GAIN,
                                    (h1.getLevel() - h2.getLevel()) * Constants.XP_GAIN);
                            h1.setXp(h1.getXp() + max);     // increase the xp
                            h1.levelUp(fs);                 // try to level up
                        }
                    }
                    if (h1.getHp() <= 0) {
                        h2.notifyObserver(fs, h1);
                        h1.setHp(0);
                        h1.setAlive(false);
                        if (h2.getHp() > 0) {
                            int max = Math.max(Constants.MAX_XP_GAIN,
                                    (h2.getLevel() - h1.getLevel()) * Constants.XP_GAIN);
                            h2.setXp(h2.getXp() + max);
                            h2.levelUp(fs);
                        }
                    }
                    h1.setFight(false);
                    h2.setFight(false);
                }
            }
        }
//        System.out.println("Dupa lupta:");
//        for (Hero h : getHeroes()) {
//            System.out.println(h.getType() + " " + h.getHp());
//        }
    }

    public void spawnAngels(final int round, final FileSystem fs) {
        for (Angel a : AllAngels.getInstance().getAngels().get(round).getAngels()) {
            a.notifyObserver(fs);       // notify The Great Magicien when an angel spawns
            for (Hero h : AllHeroes.getInstance().getHeroes()) {
                if (h.getX() == a.getX() && h.getY() == a.getY()) { // hero same spot with angel
                    if (h.getHp() > 0 || a.getName().equals("Spawner")) {   // and hero is alive
                                                    // or the angel can bring the hero back to life
                        int prevHp = h.getHp();
                        h.angelsHelp(a);        // let the angel help/hit
                        if (a.getName().equals("DarkAngel") || a.getName().equals("Dracula")
                                || a.getName().equals("TheDoomer")) {
                            a.notifyObserver(fs, "hit", h);
                        } else {
                            if (!a.getName().equals("Spawner")
                                    || prevHp <= 0) {
                                a.notifyObserver(fs, "helped", h);
                                if (a.getName().equals("LevelUpAngel")
                                        || a.getName().equals("XPAngel")) {
                                    h.levelUp(fs);
                                }
                            }
                            if (prevHp <= 0 && h.getHp() > 0) {
                                a.notifyObserver(fs, "Spawner", h);
                            }
                        }
                        if (h.getHp() <= 0) {
                            a.notifyObserver(fs, "killed", h);
                        }
                    }
                }
            }
        }
//        System.out.println("Dupa ingeri");
//        for (Hero h : getHeroes()) {
//            System.out.println(h.getType() + " " + h.getHp());
//        }
        for (Hero h : AllHeroes.getInstance().getHeroes()) {
            if (h.getHp() <= 0) {
                h.setAlive(false);
            }
        }
    }

    public void endOfGame(final FileSystem fs) {
        try {
            fs.writeWord("~~ Results ~~");
            fs.writeNewLine();
            for (Hero hero : getHeroes()) {
                if (!hero.isAlive()) {
                    fs.writeWord(hero.getType() + " dead");
                    fs.writeNewLine();
                } else {
                    fs.writeWord(hero.toString());
                    fs.writeNewLine();
                }
            }
            fs.writeNewLine();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

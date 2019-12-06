package hero;

import constants.Constants;
import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;

public final class AllHeroes {
    private ArrayList<Hero> heroes = new ArrayList<>();

    public AllHeroes() {
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void showPlayers() {
        for (Hero hero : getHeroes()) {
            System.out.println(hero.toString());
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

    public void moveHeroes(final int round, final ArrayList<String> moves,
                           final ArrayList<String> map) {
        for (int i = 0; i < getHeroes().size(); i++) {
            Hero h = getHeroes().get(i);
            if (h.canMove()) {
                switch (moves.get(round).charAt(i)) {
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
                h.setMap(map.get(h.getX()).charAt(h.getY()));
            }
        }
    }
    private void applyOvertimeDamage(final int round) {
        for (Hero h : getHeroes()) {
            if (h.isAlive() && h.getRoundsReceiveOTD() > 0) {
                h.applyOTD(round);
            }
        }
    }

    public void startFight(final int round, final ArrayList<String> moves,
                           final ArrayList<String> map) {
        moveHeroes(round, moves, map);
        applyOvertimeDamage(round);
        for (int i = 0; i < getHeroes().size(); i++) {
            Hero h1 = getHeroes().get(i);
            int index = findOponent(h1);
            if (index != -1) {
                Hero h2 = getHeroes().get(index);
                if (h1.isAlive() && h2.isAlive()) {
                    h1.fightOpponent(h2, round); // h2 applyes abilities on h1
                    h2.fightOpponent(h1, round); // h2 applyes abilities on h1
                    if (h1.getHp() <= 0) {
                        h1.setHp(0);
                        if (h2.getHp() > 0) {
                            int max = Math.max(Constants.MAX_XP_GAIN,
                                    (h2.getLevel() - h1.getLevel()) * Constants.XP_GAIN);
                            h2.setXp(h2.getXp() + max);
                        }
                    }
                    if (h2.getHp() <= 0) {
                        h2.setHp(0);
                        if (h1.getHp() > 0) {
                            int max = Math.max(Constants.MAX_XP_GAIN,
                                    (h1.getLevel() - h2.getLevel()) * Constants.XP_GAIN);
                            h1.setXp(h1.getXp() + max);
                        }

                    }
                    h1.setFight(false);
                    h2.setFight(false);
                    h2.levelUp();
                }
            }
            h1.levelUp();
        }
        for (Hero h : getHeroes()) {
            if (h.getHp() <= 0) {
                h.setAlive(false);
            }
        }
    }
    public void endOfGame(final String input, final String output) {
        try {
            FileSystem fs = new FileSystem(input, output);
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

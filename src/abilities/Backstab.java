package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

import java.util.ArrayList;

public final class Backstab implements AbilitiesVisitor {
    private int level;
    private int round;
    private ArrayList<Float> coef;
    private static final int K = 0;
    private static final int W = 1;
    private static final int R = 2;
    private static final int P = 3;
    public Backstab(final int level, final int round, final ArrayList<Float> coef) {
        this.level = level;
        this.round = round;
        this.coef = coef;
    }
    @Override
    public void visit(final Hero hero) {
    }

    @Override
    public void visit(final Knight knight) {
        int dmg = Math.round((Constants.BACKSTAB_BASE + Constants.BACKSTAB_LVL * level)
                * coef.get(K));  // calculate the damage with race amplifier
        if (knight.getMap() == 'W') {  // if necessary, add WOODS bonus
            if (round % Constants.THIRD_ROUND == 0) {
                dmg = Math.round(Constants.ROGUE_CRITICAL * dmg * Constants.WOODS);
            } else {
                dmg = Math.round(dmg * Constants.WOODS);
            }
        }
        knight.setHp(knight.getHp() - dmg);
        //System.out.println("Backstab " + dmg);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        int dmg = Math.round((Constants.BACKSTAB_BASE + Constants.BACKSTAB_LVL * level)
                * coef.get(P));
        if (pyromancer.getMap() == 'W') {
            dmg = Math.round(dmg * Constants.WOODS);
            if (round % Constants.THIRD_ROUND == 0) {
                dmg = Math.round(Constants.ROGUE_CRITICAL * dmg);
            }
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
    }

    @Override
    public void visit(final Rogue rogue) {
        int dmg = Math.round((Constants.BACKSTAB_BASE + Constants.BACKSTAB_LVL * level)
                * coef.get(R));
        if (rogue.getMap() == 'W') {
            dmg = Math.round(dmg * Constants.WOODS);
            if (round % Constants.THIRD_ROUND == 0) {
                dmg = Math.round(Constants.ROGUE_CRITICAL * dmg);
            }
        }
        rogue.setHp(rogue.getHp() - dmg);
    }

    @Override
    public void visit(final Wizard wizard) {
        int dmg = Math.round((Constants.BACKSTAB_BASE + Constants.BACKSTAB_LVL * level)
                * coef.get(W));
        if (wizard.getMap() == 'W') {
            dmg = Math.round(dmg * Constants.WOODS);
            if (round % Constants.THIRD_ROUND == 0) {
                dmg = Math.round(Constants.ROGUE_CRITICAL * dmg);
            }
        }
        wizard.setHp(wizard.getHp() - dmg);
        System.out.println("Backstab " + dmg);
    }

}

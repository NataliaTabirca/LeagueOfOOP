package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

import java.util.ArrayList;

public final class Fireblast implements AbilitiesVisitor {
    private int level;
    private ArrayList<Float> coef;
    private static final int K = 0;
    private static final int W = 1;
    private static final int R = 2;
    private static final int P = 3;
    public Fireblast(final int level, final ArrayList<Float> coef) {
        this.level = level;
        this.coef = coef;
    }

    @Override
    public void visit(final Hero hero) {
    }

    @Override
    public void visit(final Knight knight) {
        int dmg = Math.round((Constants.FIREBLAST_BASE + Constants.FIREBLAST_LVL * level)
                * coef.get(K));
        if (knight.getMap() == 'V') {  // if necessary, add VOLCANIC bonus
            dmg = Math.round(dmg * Constants.VOLCANIC);
        }
        knight.setHp(knight.getHp() - dmg);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        int dmg = Math.round((Constants.FIREBLAST_BASE + Constants.FIREBLAST_LVL * level)
                * coef.get(P));
        if (pyromancer.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
    }

    @Override
    public void visit(final Rogue rogue) {
        int dmg = Math.round((Constants.FIREBLAST_BASE + Constants.FIREBLAST_LVL * level)
                * coef.get(R));
        if (rogue.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
        }
        rogue.setHp(rogue.getHp() - dmg);
    }

    @Override
    public void visit(final Wizard wizard) {
        int dmg = Math.round((Constants.FIREBLAST_BASE + Constants.FIREBLAST_LVL * level)
                * coef.get(W));
        if (wizard.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
        }
        wizard.setHp(wizard.getHp() - dmg);
        // System.out.println("Fireblast " + dmg);
    }
}

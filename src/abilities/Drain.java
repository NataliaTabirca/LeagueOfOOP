package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

import java.util.ArrayList;

public final class Drain implements AbilitiesVisitor {
    private int level;
    private ArrayList<Float> coef;
    private static final int K = 0;
    private static final int W = 1;
    private static final int R = 2;
    private static final int P = 3;
    public Drain(final int level, final ArrayList<Float> coef) {
        this.level = level;
        this.coef = coef;
    }

    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        float min = Math.min(Constants.DRAIN_BASE * knight.maxHp(), knight.getHp());
        int dmg = Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                * min * coef.get(K));
        if (knight.getMap() == 'D') {  // if necessary, add DESERT bonus
            dmg = Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                    * min * coef.get(K) * Constants.DESERT);
        }
        knight.setHp(knight.getHp() - dmg);
//        System.out.println("Drain " + dmg);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        float min = Math.min(Constants.DRAIN_BASE * pyromancer.maxHp(), pyromancer.getHp());
        int dmg = Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                * min * coef.get(P));
        if (pyromancer.getMap() == 'D') {
            dmg = Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                    * min * coef.get(P) * Constants.DESERT);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
        //System.out.println("Drain " + dmg);
    }

    @Override
    public void visit(final Rogue rogue) {
        float min = Math.min(Constants.DRAIN_BASE * rogue.maxHp(), rogue.getHp());
        int dmg = Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                * min * coef.get(R));
        if (rogue.getMap() == 'D') {
            dmg = Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                    * min * coef.get(R) * Constants.DESERT);
        }
        rogue.setHp(rogue.getHp() - dmg);
        System.out.println("Drain " + dmg);
    }

    @Override
    public void visit(final Wizard wizard) {
        float min = Math.min(Constants.DRAIN_BASE * wizard.maxHp(), wizard.getHp());
        int dmg = Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                * min * coef.get(W));
        if (wizard.getMap() == 'D') {
            dmg = Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                    * min * coef.get(W) * Constants.DESERT);
        }
        wizard.setHp(wizard.getHp() - dmg);
    }

}

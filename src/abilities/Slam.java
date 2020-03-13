package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

import java.util.ArrayList;

public final class Slam implements AbilitiesVisitor {
    private int level;
    private ArrayList<Float> coef;
    private static final int K = 4;
    private static final int W = 5;
    private static final int R = 6;
    private static final int P = 7;
    public Slam(final int level, final ArrayList<Float> coef) {
        this.level = level;
        this.coef = coef;
    }

    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        int dmg = Math.round((Constants.SLAM_BASE + Constants.SLAM_LVL * level)
                * coef.get(K));
        if (knight.getMap() == 'L') { // if necessary, add LAND bonus
            dmg = Math.round(dmg * Constants.LAND);
        }
        knight.setHp(knight.getHp() - dmg);
        knight.setMove(false);
        knight.setRoundsReceiveOTD(1);
        knight.setOdt(0);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        int dmg = Math.round((Constants.SLAM_BASE + Constants.SLAM_LVL * level)
                * coef.get(P));
        if (pyromancer.getMap() == 'L') {
            dmg = Math.round(dmg * Constants.LAND);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
        pyromancer.setMove(false);
        pyromancer.setRoundsReceiveOTD(1);
        pyromancer.setOdt(0);
    }

    @Override
    public void visit(final Rogue rogue) {
        int dmg = Math.round((Constants.SLAM_BASE + Constants.SLAM_LVL * level)
                * coef.get(R));
        if (rogue.getMap() == 'L') {
            dmg = Math.round(dmg * Constants.LAND);
        }
        rogue.setHp(rogue.getHp() - dmg);
        rogue.setMove(false);
        rogue.setRoundsReceiveOTD(1);
        rogue.setOdt(0);
    }

    @Override
    public void visit(final Wizard wizard) {
        int dmg = Math.round((Constants.SLAM_BASE + Constants.SLAM_LVL * level)
                * coef.get(W));
        if (wizard.getMap() == 'L') {
            dmg = Math.round(dmg * Constants.LAND);
        }
        wizard.setHp(wizard.getHp() - dmg);
        wizard.setMove(false);
        wizard.setRoundsReceiveOTD(1);
        wizard.setOdt(0);
        System.out.println("Slam " + dmg);
    }
}

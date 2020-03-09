package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

import java.util.ArrayList;

public final class Ignite implements AbilitiesVisitor {
    private int level;
    private int odt;
    private ArrayList<Float> coef;
    private static final int K = 4;
    private static final int W = 5;
    private static final int R = 6;
    private static final int P = 7;
    public Ignite(final int level, final int odt, final ArrayList<Float> coef) {
        this.level = level;
        this.odt = odt;
        this.coef = coef;
    }
    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        int dmg = Math.round((Constants.IGNITE_BASE + Constants.IGNITE_LVL * level)
                * coef.get(K));
        if (knight.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
            odt = Math.round(odt * Constants.VOLCANIC);
        }
        knight.setHp(knight.getHp() - dmg);
        knight.setOdt(Math.round(odt * coef.get(K)));
        knight.setRoundsReceiveOTD(Constants.TWO_ROUNDS);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        int dmg = Math.round((Constants.IGNITE_BASE + Constants.IGNITE_LVL * level)
                * coef.get(P));
        if (pyromancer.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
            odt = Math.round(odt * Constants.VOLCANIC);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
        pyromancer.setOdt(Math.round(odt * coef.get(P)));
        pyromancer.setRoundsReceiveOTD(Constants.TWO_ROUNDS);
    }

    @Override
    public void visit(final Rogue rogue) {
        int dmg = Math.round((Constants.IGNITE_BASE + Constants.IGNITE_LVL * level)
                * coef.get(R));
        if (rogue.getMap() == 'V') { // if necessary, add LAND bonus
            dmg = Math.round(dmg * Constants.VOLCANIC);
            odt = Math.round(odt * Constants.VOLCANIC);
        }
        rogue.setHp(rogue.getHp() - dmg);
        rogue.setOdt(Math.round(odt * coef.get(R)));  // set overtime damage
        rogue.setRoundsReceiveOTD(Constants.TWO_ROUNDS);  // set overtime rounds on 2
    }

    @Override
    public void visit(final Wizard wizard) {
        int dmg = Math.round((Constants.IGNITE_BASE + Constants.IGNITE_LVL * level)
                * coef.get(W));
        if (wizard.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
            odt = Math.round(odt * Constants.VOLCANIC);
        }
        wizard.setHp(wizard.getHp() - dmg);
        wizard.setOdt(Math.round(odt * coef.get(W)));
        wizard.setRoundsReceiveOTD(Constants.TWO_ROUNDS);
        // System.out.println("Ignite " + dmg);
    }
}

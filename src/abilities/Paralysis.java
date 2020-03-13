package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

import java.util.ArrayList;

public final class Paralysis implements AbilitiesVisitor {
    private int level;
    private int odt;
    private ArrayList<Float> coef;
    private static final int K = 4;
    private static final int W = 5;
    private static final int R = 6;
    private static final int P = 7;
    private static final float HALF = 0.5f;
    public Paralysis(final int level, final int odt, final ArrayList<Float> coef) {
        this.level = level;
        this.odt = odt;
        this.coef = coef;
    }

    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        float aux = (Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * level)
                * coef.get(K);
        int dmg;
        if (aux - (int) aux == HALF) {
            dmg = (int) (aux);
        } else {
            dmg = Math.round(aux);
        }
        if (knight.getMap() == 'W') { // if necessary, add WOODS bonus
            dmg = Math.round(dmg * Constants.WOODS);
            knight.setRoundsReceiveOTD(Constants.SIX_ROUNDS);  // make odt rounds on 6
            odt = Math.round(odt * Constants.WOODS);  // add odt bonus WOODS
        } else {
            knight.setRoundsReceiveOTD(Constants.THREE_ROUNDS);
        }
        knight.setHp(knight.getHp() - dmg);
        knight.setMove(false);
        knight.setOdt(Math.round(odt * coef.get(K)));
        //System.out.println("Paralisys " + dmg);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        float aux = (Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * level)
                * coef.get(P);
        int dmg;
        if (aux - (int) aux == HALF) {
            dmg = (int) (aux);
        } else {
            dmg = Math.round(aux);
        }
        if (pyromancer.getMap() == 'W') {
            dmg = Math.round(dmg * Constants.WOODS);
            pyromancer.setRoundsReceiveOTD(Constants.SIX_ROUNDS);
            odt = Math.round(odt * Constants.WOODS);
        } else {
            pyromancer.setRoundsReceiveOTD(Constants.THREE_ROUNDS);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
        pyromancer.setMove(false);
        pyromancer.setOdt(Math.round(odt * coef.get(P)));
    }

    @Override
    public void visit(final Rogue rogue) {
        float aux = (Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * level)
                * coef.get(R);
        int dmg;
        if (aux - (int) aux == HALF) {
            dmg = (int) (aux);
        } else {
            dmg = Math.round(aux);
        }
        if (rogue.getMap() == 'W') {
            dmg = Math.round(dmg * Constants.WOODS);
            rogue.setRoundsReceiveOTD(Constants.SIX_ROUNDS);
            odt = Math.round(odt * Constants.WOODS);
        } else {
            rogue.setRoundsReceiveOTD(Constants.THREE_ROUNDS);
        }
        rogue.setHp(rogue.getHp() - dmg);
        rogue.setMove(false);
        rogue.setOdt(Math.round(odt * coef.get(R)));

    }

    @Override
    public void visit(final Wizard wizard) {
        float aux = (Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * level)
                * coef.get(W);
        int dmg;
        if (aux - (int) aux == HALF) {
            dmg = (int) (aux);
        } else {
            dmg = Math.round(aux);
        }
        if (wizard.getMap() == 'W') {
            dmg = Math.round(dmg * Constants.WOODS);
            wizard.setRoundsReceiveOTD(Constants.SIX_ROUNDS);
            odt = Math.round(odt * Constants.WOODS);
        } else {
            wizard.setRoundsReceiveOTD(Constants.THREE_ROUNDS);
        }
        wizard.setHp(wizard.getHp() - dmg);
        wizard.setMove(false);
        wizard.setOdt(Math.round(odt * coef.get(W)));
        System.out.println("Paralisys " + dmg);
    }
}

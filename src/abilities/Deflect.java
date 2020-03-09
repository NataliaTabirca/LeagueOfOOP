package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

import java.util.ArrayList;

public final class Deflect implements AbilitiesVisitor {
    private int level;
    private int hp;
    private int round;
    private ArrayList<Float> coef;
    private static final int K = 4;
    private static final int R = 6;
    private static final int P = 7;
    public Deflect(final int level, final int hp, final int round, final ArrayList<Float> coef) {
        this.level = level;
        this.hp = hp;
        this.round = round;
        this.coef = coef;
    }

    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        float percent = Math.min(Constants.DEFLECT_BASE + Constants.DEFLECT_LVL * level,
                Constants.DEFLECT_MAX);  // calculate percentage for damage
        int dmg = Math.round(percent * knight.flatDamage() * coef.get(K));
        if (knight.getMap() == 'D') {  // if necessary, add DESERT bonus
            dmg = Math.round(dmg * Constants.DESERT);
        }
        knight.setHp(knight.getHp() - dmg);
       // System.out.println("Deflect " + dmg);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        float percent = Math.min(Constants.DEFLECT_BASE + Constants.DEFLECT_LVL * level,
                Constants.DEFLECT_MAX);
        int dmg = Math.round(Math.round(percent * pyromancer.flatDamage())
                * coef.get(P));
        if (pyromancer.getMap() == 'D') {
            dmg = Math.round(dmg * Constants.DESERT);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
       // System.out.println("Deflect " + dmg);
    }

    @Override
    public void visit(final Rogue rogue) {
        int dmg;
        if (round % Constants.THIRD_ROUND == 0 && rogue.getMap() == 'W') {
            int backstab = Math.round((Constants.BACKSTAB_BASE + Constants.BACKSTAB_LVL
                    * rogue.getLevel()) * Constants.ROGUE_CRITICAL);
            int paralisys = Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * rogue.getLevel();
            dmg = backstab + paralisys;
        } else {
            dmg = rogue.flatDamage();
        }
        float percent = Math.min(Constants.DEFLECT_BASE + Constants.DEFLECT_LVL * level,
                Constants.DEFLECT_MAX);
        System.out.println("Rougue flat damage: " + dmg);
        System.out.println("procent: " + percent);
        if (rogue.getMap() == 'W') {
            dmg = Math.round(percent * dmg * coef.get(R) * Constants.WOODS);
        } else {
            if (rogue.getMap() == 'D') {
                dmg = Math.round(percent * dmg * coef.get(R) * Constants.DESERT);
            } else {
                dmg = Math.round(percent * dmg * coef.get(R));
            }
        }
        rogue.setHp(rogue.getHp() - dmg);
        System.out.println("Deflect " + dmg);
    }

    @Override
    public void visit(final Wizard wizard) {
    }
}

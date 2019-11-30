package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Backstab implements AbilitiesVisitor {
    private int level;
    private int round;
    public Backstab(final int level, final int round) {
        this.level = level;
        this.round = round;
    }
    @Override
    public void visit(final Hero hero) {
    }

    @Override
    public void visit(final Knight knight) {
        int dmg = Math.round((Constants.BACKSTAB_BASE + Constants.BACKSTAB_LVL * level)
                * Constants.BACKSTAB_KNIGHT);  // calculate the damage with race amplifier
        if (knight.getMap() == 'W') {  // if necessary, add WOODS bonus
            if (round % Constants.THIRD_ROUND == 0) {
                dmg = Math.round(Constants.ROGUE_CRITICAL * dmg * Constants.WOODS);
            } else {
                dmg = Math.round(dmg * Constants.WOODS);
            }
        }
        knight.setHp(knight.getHp() - dmg);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        int dmg = Math.round((Constants.BACKSTAB_BASE + Constants.BACKSTAB_LVL * level)
                * Constants.BACKSTAB_PYROMANCER);
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
                * Constants.BACKSTAB_ROGUE);
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
                * Constants.BACKSTAB_WIZARD);
        if (wizard.getMap() == 'W') {
           dmg = Math.round(dmg * Constants.WOODS);
            if (round % Constants.THIRD_ROUND == 0) {
                dmg = Math.round(Constants.ROGUE_CRITICAL * dmg);
            }
        }
        wizard.setHp(wizard.getHp() - dmg);
    }

}

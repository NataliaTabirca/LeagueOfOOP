package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Execute implements AbilitiesVisitor {
    private int level;

    public Execute(final int level) {
        this.level = level;
    }

    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        float percent = Math.min(Constants.EXECUTE_HP_BASE + Constants.EXECUTE_HP_LVL * level,
                Constants.EXECUTE_HP_MAX);
        int hpLimit = Math.round(percent * knight.maxHp());
        if (knight.getHp() <= hpLimit) { // verify if knight instantly kills adversary
            knight.setHp(0);
        } else {
            int dmg = Math.round((Constants.EXECUTE_BASE + Constants.EXECUTE_LVL * level)
                    * Constants.EXECUTE_KNIGHT);
            if (knight.getMap() == 'L') {  // if necessary, add LAND bonus
                dmg = Math.round(dmg * Constants.LAND);
            }
            knight.setHp(knight.getHp() - dmg);
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        float percent = Math.min(Constants.EXECUTE_HP_BASE + Constants.EXECUTE_HP_LVL * level,
                Constants.EXECUTE_HP_MAX);
        int hpLimit = Math.round(percent * pyromancer.maxHp());
        if (pyromancer.getHp() <= hpLimit) {
            pyromancer.setHp(0);
        } else {
            int dmg = Math.round((Constants.EXECUTE_BASE + Constants.EXECUTE_LVL * level)
                    * Constants.EXECUTE_PYROMANCER);
            if (pyromancer.getMap() == 'L') {
                dmg = Math.round(dmg * Constants.LAND);
            }
            pyromancer.setHp(pyromancer.getHp() - dmg);
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        float percent = Math.min(Constants.EXECUTE_HP_BASE + Constants.EXECUTE_HP_LVL * level,
                Constants.EXECUTE_HP_MAX);
        int hpLimit = Math.round(percent * rogue.maxHp());
        if (rogue.getHp() <= hpLimit) {
            rogue.setHp(0);
        } else {
            int dmg = Math.round((Constants.EXECUTE_BASE + Constants.EXECUTE_LVL * level)
                    * Constants.EXECUTE_ROGUE);
            if (rogue.getMap() == 'L') {
                dmg = Math.round(dmg * Constants.LAND);
            }
            rogue.setHp(rogue.getHp() - dmg);
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        float percent = Math.min(Constants.EXECUTE_HP_BASE + Constants.EXECUTE_HP_LVL * level,
                Constants.EXECUTE_HP_MAX);
        int hpLimit = Math.round(percent * wizard.maxHp());
        if (wizard.getHp() <= hpLimit) {
            wizard.setHp(0);
        } else {
            int dmg = Math.round((Constants.EXECUTE_BASE + Constants.EXECUTE_LVL * level)
                    * Constants.EXECUTE_WIZARD);
            if (wizard.getMap() == 'L') {
                dmg = Math.round(dmg * Constants.LAND);
            }
            wizard.setHp(wizard.getHp() - dmg);
        }
    }
}

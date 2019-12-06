package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Drain implements AbilitiesVisitor {
    private int level;

    public Drain(final int level) {
        this.level = level;
    }

    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        double min = Math.min(Constants.DRAIN_BASE * knight.maxHp(), knight.getHp());
        int dmg = (int) Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                * min * Constants.DRAIN_KNIGHT);
        if (knight.getMap() == 'D') {  // if necessary, add DESERT bonus
            dmg = (int) Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                    * min * Constants.DRAIN_KNIGHT * Constants.DESERT);
        }
        knight.setHp(knight.getHp() - dmg);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        double min = Math.min(Constants.DRAIN_BASE * pyromancer.maxHp(), pyromancer.getHp());
        int dmg = (int) Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                * min * Constants.DRAIN_PYROMANCER);
        if (pyromancer.getMap() == 'D') {
            dmg = (int) Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                    * min * Constants.DRAIN_PYROMANCER * Constants.DESERT);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
    }

    @Override
    public void visit(final Rogue rogue) {
        double min = Math.min(Constants.DRAIN_BASE * rogue.maxHp(), rogue.getHp());
        int dmg = (int) Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                * min * Constants.DRAIN_ROGUE);
        if (rogue.getMap() == 'D') {
            dmg = Math.round(dmg * Constants.DESERT);
        }
        rogue.setHp(rogue.getHp() - dmg);
    }

    @Override
    public void visit(final Wizard wizard) {
        double min = Math.min(Constants.DRAIN_BASE * wizard.maxHp(), wizard.getHp());
        int dmg = (int) Math.round((Constants.DRAIN_HP_PER + Constants.DRAIN_LVL * level)
                * min * Constants.DRAIN_WIZARD);
        if (wizard.getMap() == 'D') {
            dmg = Math.round(dmg * Constants.DESERT);
        }
        wizard.setHp(wizard.getHp() - dmg);
    }

}

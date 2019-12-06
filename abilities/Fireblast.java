package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Fireblast implements AbilitiesVisitor {
    private int level;

    public Fireblast(final int level) {
        this.level = level;
    }

    @Override
    public void visit(final Hero hero) {
    }

    @Override
    public void visit(final Knight knight) {
        int dmg = Math.round((Constants.FIREBLAST_BASE + Constants.FIREBLAST_LVL * level)
                * Constants.FIREBLAST_KNIGHT);
        if (knight.getMap() == 'V') {  // if necessary, add VOLCANIC bonus
            dmg = Math.round(dmg * Constants.VOLCANIC);
        }
        knight.setHp(knight.getHp() - dmg);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        int dmg = Math.round((Constants.FIREBLAST_BASE + Constants.FIREBLAST_LVL * level)
                * Constants.FIREBLAST_PYROMANCER);
        if (pyromancer.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
    }

    @Override
    public void visit(final Rogue rogue) {
        int dmg = Math.round((Constants.FIREBLAST_BASE + Constants.FIREBLAST_LVL * level)
                * Constants.FIREBLAST_ROGUE);
        if (rogue.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
        }
        rogue.setHp(rogue.getHp() - dmg);
    }

    @Override
    public void visit(final Wizard wizard) {
        int dmg = Math.round((Constants.FIREBLAST_BASE + Constants.FIREBLAST_LVL * level)
                * Constants.FIREBLAST_WIZARD);
        if (wizard.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
        }
        wizard.setHp(wizard.getHp() - dmg);
    }
}

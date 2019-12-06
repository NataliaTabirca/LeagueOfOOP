package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Ignite implements AbilitiesVisitor {
    private int level;
    private int odt;
    public Ignite(final int level, final int odt) {
        this.level = level;
        this.odt = odt;
    }
    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        int dmg = Math.round((Constants.IGNITE_BASE + Constants.IGNITE_LVL * level)
                * Constants.IGNITE_KNIGHT);
        if (knight.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
            odt = Math.round(odt * Constants.VOLCANIC);
        }
        knight.setHp(knight.getHp() - dmg);
        knight.setOdt(Math.round(odt * Constants.IGNITE_KNIGHT));
        knight.setRoundsReceiveOTD(Constants.TWO_ROUNDS);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        int dmg = Math.round((Constants.IGNITE_BASE + Constants.IGNITE_LVL * level)
                * Constants.IGNITE_PYROMANCER);
        if (pyromancer.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
            odt = Math.round(odt * Constants.VOLCANIC);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
        pyromancer.setOdt(Math.round(odt * Constants.IGNITE_PYROMANCER));
        pyromancer.setRoundsReceiveOTD(Constants.TWO_ROUNDS);
    }

    @Override
    public void visit(final Rogue rogue) {
        int dmg = Math.round((Constants.IGNITE_BASE + Constants.IGNITE_LVL * level)
                * Constants.IGNITE_ROGUE);
        if (rogue.getMap() == 'V') { // if necessary, add LAND bonus
            dmg = Math.round(dmg * Constants.VOLCANIC);
            odt = Math.round(odt * Constants.VOLCANIC);
        }
        rogue.setHp(rogue.getHp() - dmg);
        rogue.setOdt(Math.round(odt * Constants.IGNITE_ROGUE));  // set overtime damage
        rogue.setRoundsReceiveOTD(Constants.TWO_ROUNDS);  // set overtime rounds on 2
    }

    @Override
    public void visit(final Wizard wizard) {
        int dmg = Math.round((Constants.IGNITE_BASE + Constants.IGNITE_LVL * level)
                * Constants.IGNITE_WIZARD);
        if (wizard.getMap() == 'V') {
            dmg = Math.round(dmg * Constants.VOLCANIC);
            odt = Math.round(odt * Constants.VOLCANIC);
        }
        wizard.setHp(wizard.getHp() - dmg);
        wizard.setOdt(Math.round(odt * Constants.IGNITE_WIZARD));
        wizard.setRoundsReceiveOTD(Constants.TWO_ROUNDS);
    }
}

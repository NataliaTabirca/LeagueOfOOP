package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Paralysis implements AbilitiesVisitor {
    private int level;
    private int odt;

    public Paralysis(final int level, final int odt) {
        this.level = level;
        this.odt = odt;
    }

    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        int dmg = Math.round((Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * level)
                * Constants.PARALISYS_KNIGHT);
        if (knight.getMap() == 'W') { // if necessary, add WOODS bonus
            dmg = Math.round(dmg * Constants.WOODS);
            knight.setRoundsReceiveOTD(Constants.SIX_ROUNDS);  // make odt rounds on 6
            odt = Math.round(odt * Constants.WOODS);  // add odt bonus WOODS
        } else {
            knight.setRoundsReceiveOTD(Constants.THREE_ROUNDS);
        }
        knight.setHp(knight.getHp() - dmg);
        knight.setMove(false);
        knight.setOdt(Math.round(odt * Constants.PARALISYS_KNIGHT));
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        int dmg = Math.round((Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * level)
                * Constants.PARALISYS_PYROMANCER);
        if (pyromancer.getMap() == 'W') {
            dmg = Math.round(dmg * Constants.WOODS);
            pyromancer.setRoundsReceiveOTD(Constants.SIX_ROUNDS);
            odt = Math.round(odt * Constants.WOODS);
        } else {
            pyromancer.setRoundsReceiveOTD(Constants.THREE_ROUNDS);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
        pyromancer.setMove(false);
        pyromancer.setOdt(Math.round(odt * Constants.PARALISYS_PYROMANCER));
    }

    @Override
    public void visit(final Rogue rogue) {
        int dmg = Math.round((Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * level)
                * Constants.PARALISYS_ROGUE);
        if (rogue.getMap() == 'W') {
            dmg = Math.round(dmg * Constants.WOODS);
            rogue.setRoundsReceiveOTD(Constants.SIX_ROUNDS);
            odt = Math.round(odt * Constants.WOODS);
        } else {
            rogue.setRoundsReceiveOTD(Constants.THREE_ROUNDS);
        }
        rogue.setHp(rogue.getHp() - dmg);
        rogue.setMove(false);
        rogue.setOdt(Math.round(odt * Constants.PARALISYS_ROGUE));
    }

    @Override
    public void visit(final Wizard wizard) {
        int dmg = Math.round((Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * level)
                * Constants.PARALISYS_WIZARD);
        if (wizard.getMap() == 'W') {
            dmg = Math.round(dmg * Constants.WOODS);
            wizard.setRoundsReceiveOTD(Constants.SIX_ROUNDS);
            odt = Math.round(odt * Constants.WOODS);
        } else {
            wizard.setRoundsReceiveOTD(Constants.THREE_ROUNDS);
        }
        wizard.setHp(wizard.getHp() - dmg);
        wizard.setMove(false);
        wizard.setOdt(Math.round(odt * Constants.PARALISYS_WIZARD));
    }
}

package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Slam implements AbilitiesVisitor {
    private int level;

    public Slam(final int level) {
        this.level = level;
    }

    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        int dmg = Math.round((Constants.SLAM_BASE + Constants.SLAM_LVL * level)
                * Constants.SLAM_KNIGHT);
        if (knight.getMap() == 'L') { // if necessary, add LAND bonus
            dmg = Math.round(dmg * Constants.LAND);
        }
        knight.setHp(knight.getHp() - dmg);
        knight.setMove(false);
        knight.setRoundsReceiveOTD(1);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        int dmg = Math.round((Constants.SLAM_BASE + Constants.SLAM_LVL * level)
                * Constants.SLAM_PYROMANCER);
        if (pyromancer.getMap() == 'L') {
            dmg = Math.round(dmg * Constants.LAND);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
        pyromancer.setMove(false);
        pyromancer.setRoundsReceiveOTD(1);
    }

    @Override
    public void visit(final Rogue rogue) {
        int dmg = Math.round((Constants.SLAM_BASE + Constants.SLAM_LVL * level)
                * Constants.SLAM_ROGUE);
        if (rogue.getMap() == 'L') {
            dmg = Math.round(dmg * Constants.LAND);
        }
        rogue.setHp(rogue.getHp() - dmg);
        rogue.setMove(false);
        rogue.setRoundsReceiveOTD(1);
    }

    @Override
    public void visit(final Wizard wizard) {
        int dmg = Math.round((Constants.SLAM_BASE + Constants.SLAM_LVL * level)
                * Constants.SLAM_WIZARD);
        if (wizard.getMap() == 'L') {
            dmg = Math.round(dmg * Constants.LAND);
        }
        wizard.setHp(wizard.getHp() - dmg);
        wizard.setMove(false);
        wizard.setRoundsReceiveOTD(1);
    }
}

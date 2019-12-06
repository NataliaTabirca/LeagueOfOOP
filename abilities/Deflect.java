package abilities;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class Deflect implements AbilitiesVisitor {
    private int level;
    private int hp;
    private int round;
    public Deflect(final int level, final int hp, final int round) {
        this.level = level;
        this.hp = hp;
        this.round = round;
    }

    @Override
    public void visit(final Hero hero) {

    }

    @Override
    public void visit(final Knight knight) {
        float percent = Math.min(Constants.DEFLECT_BASE + Constants.DEFLECT_LVL * level,
                Constants.DEFLECT_MAX);  // calculate percentage for damage
        int dmg = Math.round(percent * knight.flatDamage() * Constants.DEFLECT_KNIGHT);
        if (knight.getMap() == 'D') {  // if necessary, add DESERT bonus
            dmg = Math.round(dmg * Constants.DESERT);
        }
        knight.setHp(knight.getHp() - dmg);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        float percent = Math.min(Constants.DEFLECT_BASE + Constants.DEFLECT_LVL * level,
                Constants.DEFLECT_MAX);
        int dmg = Math.round(Math.round(percent * pyromancer.flatDamage())
                * Constants.DEFLECT_PYROMANCER);
        if (pyromancer.getMap() == 'D') {
            dmg = Math.round(dmg * Constants.DESERT);
        }
        pyromancer.setHp(pyromancer.getHp() - dmg);
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
        dmg = (int) Math.round(percent * dmg * Constants.DEFLECT_ROGUE);
        if (rogue.getMap() == 'W') {
            dmg = Math.round(dmg * Constants.WOODS);
        }
        if (rogue.getMap() == 'D') {
            dmg = Math.round(dmg * Constants.DESERT);
        }
        rogue.setHp(rogue.getHp() - dmg);
    }

    @Override
    public void visit(final Wizard wizard) {
    }
}

package hero;

import abilities.AbilitiesVisitor;
import constants.Constants;

public final class Pyromancer extends Hero {
    public Pyromancer() { }
    public Pyromancer(final int x, final int y, final char map) {
        super(Constants.PIROMANCER_INIT_HP, 0, Constants.PIROMANCER_LVL_HP, x, y, map);
        this.setType('P');
    }
    public int maxHp() {
        return Constants.PIROMANCER_INIT_HP + getLevel() * Constants.PIROMANCER_LVL_HP;
    }

    public int flatDamage() {  // returns the damage without race amplifier
        if (getMap() == 'V') {  // if map is VOLCANIC, give land bonus
            return Math.round((Constants.FIREBLAST_BASE + Constants.FIREBLAST_LVL * getLevel()
            + Constants.IGNITE_BASE + Constants.IGNITE_LVL * getLevel()) * Constants.VOLCANIC);
        }
        return Constants.FIREBLAST_BASE + Constants.FIREBLAST_LVL * getLevel()
                + Constants.IGNITE_BASE + Constants.IGNITE_LVL * getLevel();
    }

    public int overtimeDamage() {
        return Constants.PYROMANCER_ODT +  Constants.PYROMANCER_ODT_LVL * getLevel();
    }

    public void accept(final AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
}

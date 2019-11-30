package hero;

import abilities.AbilitiesVisitor;
import constants.Constants;

public final class Rogue extends Hero {
    public Rogue() { }
    public Rogue(final int x, final int y, final char map) {
        super(Constants.ROGUE_INIT_HP, 0, Constants.ROGUE_LVL_HP, x, y, map);
        this.setType('R');
    }
    public void accept(final AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }

    public int maxHp() {
        return Constants.ROGUE_INIT_HP + getLevel() * Constants.ROGUE_LVL_HP;
    }

    public int flatDamage() {  // returns the damage without race amplifier
        if (getMap() == 'W') {  // if map is WOOD, give land bonus
            return Math.round(((Constants.BACKSTAB_BASE + Constants.BACKSTAB_LVL * getLevel())
            + (Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * getLevel())) * Constants.WOODS);
        }
        return (Constants.BACKSTAB_BASE + Constants.BACKSTAB_LVL * getLevel())
                + (Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * getLevel());
    }

    public int overtimeDamage() {
        return Constants.PARALISYS_BASE + Constants.PARALISYS_LVL * getLevel();
    }
}

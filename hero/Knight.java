package hero;

import abilities.AbilitiesVisitor;
import constants.Constants;

public final class Knight extends Hero {
    public Knight() { }
    public Knight(final int x, final int y, final char map) {
        super(Constants.KNIGHT_INIT_HP, 0, Constants.KNIGHT_LVL_HP, x, y, map);
        this.setType('K');
    }
    public int maxHp() {
        return Constants.KNIGHT_INIT_HP + getLevel() * Constants.KNIGHT_LVL_HP;
    }

    public int flatDamage() {  // returns the damage without race amplifier
        if (getMap() == 'L') {  // if map is LAND, give land bonus
            return Math.round((Constants.EXECUTE_BASE + Constants.EXECUTE_LVL * getLevel()
                    + Constants.SLAM_BASE + Constants.SLAM_LVL * getLevel()) * Constants.LAND);
        }
        return Constants.EXECUTE_BASE + Constants.EXECUTE_LVL * getLevel()
                + Constants.SLAM_BASE + Constants.SLAM_LVL * getLevel();
    }

    public void accept(final AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }

}

package hero;

import abilities.AbilitiesVisitor;
import bonuses.AngelsVisitor;
import constants.Constants;

public final class Knight extends Hero {
    public Knight() { }
    public Knight(final int x, final int y) {
        super(Constants.KNIGHT_INIT_HP, 0, Constants.KNIGHT_LVL_HP, x, y);
        this.setType('K');
        // EXECUTE
        this.getCoefficient().add(Constants.EXECUTE_KNIGHT);        // 0
        this.getCoefficient().add(Constants.EXECUTE_WIZARD);        // 1
        this.getCoefficient().add(Constants.EXECUTE_ROGUE);         // 2
        this.getCoefficient().add(Constants.EXECUTE_PYROMANCER);    // 3
        // SLAM
        this.getCoefficient().add(Constants.SLAM_KNIGHT);           // 4
        this.getCoefficient().add(Constants.SLAM_WIZARD);           // 5
        this.getCoefficient().add(Constants.SLAM_ROGUE);            // 6
        this.getCoefficient().add(Constants.SLAM_PYROMANCER);       // 7
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
    // limits for strategy
    protected static final float LOWER_LIMIT = 1 / (3f);
    protected static final float UPPER_LIMIT = 1 / (2f);
    // modifiers
    protected static final float ATACK_HP_MOD = 1 / (5f);
    protected static final float ATACK_COEF_MOD = 1 / (2f);
    protected static final float DEFENSE_HP_MOD = 1 / (4f);
    protected static final float DEFENSE_COEF_MOD = 2 / (10f);


    public void accept(final AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void accept(final AngelsVisitor angelsVisitor) {
        angelsVisitor.visit(this);
    }
}

package hero;

import abilities.AbilitiesVisitor;
import bonuses.AngelsVisitor;
import constants.Constants;

public final class Rogue extends Hero {
    public Rogue() { }
    public Rogue(final int x, final int y) {
        super(Constants.ROGUE_INIT_HP, 0, Constants.ROGUE_LVL_HP, x, y);
        this.setType('R');
        // BACKSTAB
        this.getCoefficient().add(Constants.BACKSTAB_KNIGHT);
        this.getCoefficient().add(Constants.BACKSTAB_WIZARD);
        this.getCoefficient().add(Constants.BACKSTAB_ROGUE);
        this.getCoefficient().add(Constants.BACKSTAB_PYROMANCER);
        // PARALISYS
        this.getCoefficient().add(Constants.PARALISYS_KNIGHT);
        this.getCoefficient().add(Constants.PARALISYS_WIZARD);
        this.getCoefficient().add(Constants.PARALISYS_ROGUE);
        this.getCoefficient().add(Constants.PARALISYS_PYROMANCER);
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


    // limits for strategy
    protected static final float LOWER_LIMIT = 1 / (7f);
    protected static final float UPPER_LIMIT = 1 / (5f);
    // modifiers
    protected static final float ATACK_HP_MOD = 1 / (7f);
    protected static final float ATACK_COEF_MOD = 4 / (10f);
    protected static final float DEFENSE_HP_MOD = 1 / (2f);
    protected static final float DEFENSE_COEF_MOD = 1 / (10f);

    public void accept(final AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void accept(final AngelsVisitor angelsVisitor) {
        angelsVisitor.visit(this);
    }
}

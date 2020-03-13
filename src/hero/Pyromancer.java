package hero;

import abilities.AbilitiesVisitor;
import bonuses.AngelsVisitor;
import constants.Constants;

public final class Pyromancer extends Hero {
    public Pyromancer() { }
    public Pyromancer(final int x, final int y) {
        super(Constants.PIROMANCER_INIT_HP, 0, Constants.PIROMANCER_LVL_HP, x, y);
        this.setType('P');
        // FIREBLAST
        this.getCoefficient().add(Constants.FIREBLAST_KNIGHT);
        this.getCoefficient().add(Constants.FIREBLAST_WIZARD);
        this.getCoefficient().add(Constants.FIREBLAST_ROGUE);
        this.getCoefficient().add(Constants.FIREBLAST_PYROMANCER);
        // IGNITE
        this.getCoefficient().add(Constants.IGNITE_KNIGHT);
        this.getCoefficient().add(Constants.IGNITE_WIZARD);
        this.getCoefficient().add(Constants.IGNITE_ROGUE);
        this.getCoefficient().add(Constants.IGNITE_PYROMANCER);
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

    // limits for strategy
    protected static final float LOWER_LIMIT = 1 / (4f);
    protected static final float UPPER_LIMIT = 1 / (3f);
    // modifiers
    protected static final float ATACK_HP_MOD = 1 / (4f);
    protected static final float ATACK_COEF_MOD = 7 / (10f);
    protected static final float DEFENSE_HP_MOD = 1 / (3f);
    protected static final float DEFENSE_COEF_MOD = 3 / (10f);

    public void accept(final AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
    @SuppressWarnings("checkstyle:DesignForExtension")
    public void accept(final AngelsVisitor angelsVisitor) {
        angelsVisitor.visit(this);
    }
}

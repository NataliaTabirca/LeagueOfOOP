package hero;

import abilities.AbilitiesVisitor;
import bonuses.AngelsVisitor;
import constants.Constants;

public final class Wizard extends Hero {
    public Wizard() { }
    public Wizard(final int x, final int y) {
        super(Constants.WIZARD_INIT_HP, 0, Constants.WIZARD_LVL_HP, x, y);
        this.setType('W');
        // DRAIN
        this.getCoefficient().add(Constants.DRAIN_KNIGHT);
        this.getCoefficient().add(Constants.DRAIN_WIZARD);
        this.getCoefficient().add(Constants.DRAIN_ROGUE);
        this.getCoefficient().add(Constants.DRAIN_PYROMANCER);
        // DEFLECT
        this.getCoefficient().add(Constants.DEFLECT_KNIGHT);
        this.getCoefficient().add(0f);
        this.getCoefficient().add(Constants.DEFLECT_ROGUE);
        this.getCoefficient().add(Constants.DEFLECT_PYROMANCER);
    }
    public int maxHp() {
        return Constants.WIZARD_INIT_HP + getLevel() * Constants.WIZARD_LVL_HP;
    }

    // limits for strategy
    protected static final float LOWER_LIMIT = 1 / (4f);
    protected static final float UPPER_LIMIT = 1 / (2f);
    // modifiers
    protected static final float ATACK_HP_MOD = 1 / (10f);
    protected static final float ATACK_COEF_MOD = 6 / (10f);
    protected static final float DEFENSE_HP_MOD = 1 / (5f);
    protected static final float DEFENSE_COEF_MOD = 2 / (10f);


    public void accept(final AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
    public void accept(final AngelsVisitor angelsVisitor) {
        angelsVisitor.visit(this);
    }
}

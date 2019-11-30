package hero;

import abilities.AbilitiesVisitor;
import constants.Constants;

public final class Wizard extends Hero {
    public Wizard() { }
    public Wizard(final int x, final int y, final char map) {
        super(Constants.WIZARD_INIT_HP, 0, Constants.WIZARD_LVL_HP, x, y, map);
        this.setType('W');
    }
    public void accept(final AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }

    public int maxHp() {
        return Constants.WIZARD_INIT_HP + getLevel() * Constants.WIZARD_LVL_HP;
    }
}

package Hero;

import Constants.Constants;

public class Wizard extends Hero {
    public Wizard(int x, int y, MapType map) {
        super(Constants.WIZARD_INIT_HP, 0, Constants.WIZARD_LVL_HP, x, y, map);
    }
    public void accept(AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
}

package Hero;

import Constants.Constants;

public class Rogue extends Hero {
    public Rogue(int x, int y, MapType map) {
        super(Constants.ROGUE_INIT_HP, 0, Constants.ROGUE_LVL_HP, x, y, map);
    }
    public void accept(AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
}

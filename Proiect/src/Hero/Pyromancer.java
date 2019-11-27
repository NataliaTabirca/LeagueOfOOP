package Hero;

import Constants.Constants;

public class Pyromancer extends Hero {
    public Pyromancer(int x, int y, MapType map) {
        super(Constants.PIROMANCER_INIT_HP, 0, Constants.PIROMANCER_LVL_HP, x, y, map);
    }
    public void accept(AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
}

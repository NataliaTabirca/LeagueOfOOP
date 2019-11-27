package Hero;

import Constants.Constants;

public class Knight extends Hero{

    public Knight(int x, int y, MapType map) {
        super(Constants.KNIGHT_INIT_HP, 0, Constants.KNIGHT_LVL_HP, x, y, map);
    }

    public void accept(AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
}

package bonuses;

import constants.Constants;
import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class LevelUpAngelVisit implements AngelsVisitor {

    private static final float K_MOD = 1 / 10f;
    private static final float P_MOD = 2 / 10f;
    private static final float R_MOD = 15 / 100f;
    private static final float W_MOD = 25 / 100f;
    private static final int HUNDRED = 100;

    public LevelUpAngelVisit() { }

    @Override
    public void visit(final Hero hero) { }

    @Override
    public void visit(final Knight knight) {
        knight.setXp(Constants.BASE_XP + knight.getLevel() * Constants.LVL_UP_MULT);
        for (int i = 0; i < knight.getCoefficient().size(); i++) {
            if (knight.getCoefficient().get(i) != 1) {  // coef can be modif as long as it exists
                float newVal = knight.getCoefficient().get(i) + K_MOD;
                int aux = Math.round(newVal * HUNDRED);
                newVal = aux / (float)  HUNDRED;
                knight.getCoefficient().set(i, newVal);
            }
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setXp(Constants.BASE_XP + pyromancer.getLevel() * Constants.LVL_UP_MULT);
        for (int i = 0; i < pyromancer.getCoefficient().size(); i++) {
            if (pyromancer.getCoefficient().get(i) != 1) {
                float newVal = pyromancer.getCoefficient().get(i) + P_MOD;
                int aux = Math.round(newVal * HUNDRED);
                newVal = aux / (float) HUNDRED;
                pyromancer.getCoefficient().set(i, newVal);
            }
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        rogue.setXp(Constants.BASE_XP + rogue.getLevel() * Constants.LVL_UP_MULT);
        for (int i = 0; i < rogue.getCoefficient().size(); i++) {
            if (rogue.getCoefficient().get(i) != 1) {
                float newVal = rogue.getCoefficient().get(i) + R_MOD;
                int aux = Math.round(newVal * HUNDRED);
                newVal = aux / (float) HUNDRED;
                rogue.getCoefficient().set(i, newVal);
            }
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        wizard.setXp(Constants.BASE_XP + wizard.getLevel() * Constants.LVL_UP_MULT);
        for (int i = 0; i < wizard.getCoefficient().size(); i++) {
            if (wizard.getCoefficient().get(i) != 1) {
                float newVal = wizard.getCoefficient().get(i) + W_MOD;
                int aux = Math.round(newVal * HUNDRED);
                newVal = aux / (float) HUNDRED;
                wizard.getCoefficient().set(i, newVal);
            }
        }
    }
}

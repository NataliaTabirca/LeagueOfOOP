package bonuses;

import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class DarkAngelVisit implements AngelsVisitor {
    private static final int K_HP = 40;
    private static final int P_HP = 30;
    private static final int R_HP = 10;
    private static final int W_HP = 20;
    public DarkAngelVisit() { }

    @Override
    public void visit(final Hero hero) { }

    @Override
    public void visit(final Knight knight) {
        knight.setHp(knight.getHp() - K_HP);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() - P_HP);
    }

    @Override
    public void visit(final Rogue rogue) {
        rogue.setHp(rogue.getHp() - R_HP);
    }

    @Override
    public void visit(final Wizard wizard) {
        wizard.setHp(wizard.getHp() - W_HP);
    }
}

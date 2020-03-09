package bonuses;

import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class LifeGiverVisit implements AngelsVisitor {
    private static final int K = 100;
    private static final int P = 80;
    private static final int R = 90;
    private static final int W = 120;

    public LifeGiverVisit() { }

    @Override
    public void visit(final Hero hero) { }

    @Override
    public void visit(final Knight knight) {
        int newHp = Math.min(knight.maxHp(), knight.getHp() + K);
        knight.setHp(newHp);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        int newHp = Math.min(pyromancer.maxHp(), pyromancer.getHp() + P);
        pyromancer.setHp(newHp);
    }

    @Override
    public void visit(final Rogue rogue) {
        int newHp = Math.min(rogue.maxHp(), rogue.getHp() + R);
        rogue.setHp(newHp);
    }

    @Override
    public void visit(final Wizard wizard) {
        int newHp = Math.min(wizard.maxHp(), wizard.getHp() + W);
        wizard.setHp(newHp);
    }
}

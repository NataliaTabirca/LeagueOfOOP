package bonuses;

import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class XPAngelVisit implements AngelsVisitor {
    private static final int K = 45;
    private static final int P = 50;
    private static final int R = 40;
    private static final int W = 60;
    public XPAngelVisit() { }

    @Override
    public void visit(final Hero hero) { }

    @Override
    public void visit(final Knight knight) {
        knight.setXp(knight.getXp() + K);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setXp(pyromancer.getXp() + P);
    }

    @Override
    public void visit(final Rogue rogue) {
        rogue.setXp(rogue.getXp() + R);
    }

    @Override
    public void visit(final Wizard wizard) {
        wizard.setXp(wizard.getXp() + W);
    }
}

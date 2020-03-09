package bonuses;

import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class TheDoomerVisit implements AngelsVisitor {
    public TheDoomerVisit() { }

    @Override
    public void visit(final Hero hero) { }

    @Override
    public void visit(final Knight knight) {
        knight.setHp(0);
        knight.setAlive(false);
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setHp(0);
        pyromancer.setAlive(false);
    }

    @Override
    public void visit(final Rogue rogue) {
        rogue.setHp(0);
        rogue.setAlive(false);
    }

    @Override
    public void visit(final Wizard wizard) {
        wizard.setHp(0);
        wizard.setAlive(false);
    }
}

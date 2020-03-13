package bonuses;

import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public final class SpawnerVisit implements AngelsVisitor {
    private static final int K = 200;
    private static final int P = 150;
    private static final int R = 180;
    private static final int W = 120;
    public SpawnerVisit() { }

    @Override
    public void visit(final Hero hero) { }

    @Override
    public void visit(final Knight knight) {
        if (knight.getHp() <= 0) {
            knight.setAlive(true);
            knight.setHp(K);
        }
    }

    @Override
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHp() <= 0) {
            pyromancer.setAlive(true);
            pyromancer.setHp(P);
        }
    }

    @Override
    public void visit(final Rogue rogue) {
        if (rogue.getHp() <= 0) {
            rogue.setAlive(true);
            rogue.setHp(R);
        }
    }

    @Override
    public void visit(final Wizard wizard) {
        if (wizard.getHp() <= 0) {
            wizard.setAlive(true);
            wizard.setHp(W);
        }
    }
}

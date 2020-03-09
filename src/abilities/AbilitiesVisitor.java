package abilities;

import hero.Hero;
import hero.Knight;
import hero.Pyromancer;
import hero.Rogue;
import hero.Wizard;

public interface AbilitiesVisitor {
    void visit(Hero hero);
    void visit(Knight knight);
    void visit(Pyromancer pyromancer);
    void visit(Rogue rogue);
    void visit(Wizard wizard);
}

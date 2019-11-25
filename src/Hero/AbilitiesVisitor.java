package Hero;

public interface AbilitiesVisitor {
    void visit(Hero hero);
    void visit(Knight knight);
    void visit(Pyromancer pyromancer);
    void visit(Rogue rogue);
    void visit(Wizard wizard);

    void getAbilitiesEffect(Hero hero);
}

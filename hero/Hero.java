package hero;

import abilities.AbilitiesVisitor;
import abilities.Backstab;
import abilities.Deflect;
import abilities.Drain;
import abilities.Execute;
import abilities.Fireblast;
import abilities.Ignite;
import abilities.Paralysis;
import abilities.Slam;
import constants.Constants;

public abstract class Hero {
    private int hp, xp, lvlHp;
    private int level;
    private int x, y;
    private char map;
    private char type;
    private boolean fight;
    private boolean move;
    private boolean alive;
    private int roundsReceiveOTD;
    private int odt;

    public Hero() { }
        Hero(final int hp, final int xp, final int lvlHp, final int x, final int y,
             final char map) {
            this.hp = hp;
            this.xp = xp;
            this.lvlHp = lvlHp;
            this.level = 0;
            this.x = x;
            this.y = y;
            this.map = map;
            this.fight = false;
            this.move = true;
            this.roundsReceiveOTD = 0;
            this.odt = 0;
            this.alive = true;
    }

    public final int getHp() {
        return hp;
    }
    public final void setHp(final int hp) {
        this.hp = hp;
    }
    public final int getXp() {
        return xp;
    }
    public final void setXp(final int xp) {
        this.xp = xp;
    }
    public final int getLvlHp() {
        return lvlHp;
    }
    public final void setLvlHp(final int lvlHp) {
        this.lvlHp = lvlHp;
    }
    public final int getLevel() {
        return level;
    }
    public final void setLevel(final int level) {
        this.level = level;
    }

    public final int getX() {
        return x;
    }
    public final void setX(final int x) {
        this.x = x;
    }
    public final int getY() {
        return y;
    }
    public final void setY(final int y) {
        this.y = y;
    }
    public final char getMap() {
        return map;
    }
    public final void setMap(final char map) {
        this.map = map;
    }
    public final char getType() {
        return type;
    }
    public final void setType(final char type) {
        this.type = type;
    }
    public final boolean hasFight() {
        return fight;
    }
    public final void setFight(final boolean fight) {
        this.fight = fight;
    }
    public final boolean isFight() {
        return fight;
    }
    public final boolean canMove() {
        return move;
    }
    public final void setMove(final boolean canMove) {
        this.move = canMove;
    }
    public final int getRoundsReceiveOTD() {
        return roundsReceiveOTD;
    }
    public final void setRoundsReceiveOTD(final int roundsReceiveOTD) {
        this.roundsReceiveOTD = roundsReceiveOTD;
    }
    public final int getOdt() {
        return odt;
    }
    public final void setOdt(final int odt) {
        this.odt = odt;
    }
    public final boolean isAlive() {
        return alive;
    }
    public final void setAlive(final boolean alive) {
        this.alive = alive;
    }

    public final void levelUp() {
        int xpLvlUp = Constants.BASE_XP + getLevel() * Constants.LVL_UP_MULT;
        while (getXp() - xpLvlUp >= 0) {
            setLevel(getLevel() + 1);
            xpLvlUp += Constants.LVL_UP_MULT;
        }
        if (getLevel() != 0) {  // set HP for new level for each race
            switch (getType()) {
                case 'K':
                    setHp(Constants.KNIGHT_INIT_HP + getLevel() * Constants.KNIGHT_LVL_HP);
                    break;
                case 'P':
                    setHp(Constants.PIROMANCER_INIT_HP + getLevel() * Constants.PIROMANCER_LVL_HP);
                    break;
                case 'R':
                    setHp(Constants.ROGUE_INIT_HP + getLevel() * Constants.ROGUE_LVL_HP);
                    break;
                case 'W':
                    setHp(Constants.WIZARD_INIT_HP + getLevel() * Constants.WIZARD_LVL_HP);
                    break;
                default:
                    break;
            }
        }
    }

    final boolean samePlace(final Hero hero) {
        return (this.getX() == hero.getX() && this.getY() == hero.getY());
    }

    final void applyOTD(final int round) {
        if (round != 0) {  // do not apply odt if round = 0
            this.setHp(getHp() - getOdt());
            setRoundsReceiveOTD(getRoundsReceiveOTD() - 1);
        }
        if (getRoundsReceiveOTD() == 0) {  // if odt is gone
            setMove(true); // activate ability to move
        }
        if (this.getHp() < 0) {  // if dead from odt
            this.setAlive(false);  // set dead
        }
    }
    public void accept(final AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }

    public final void fightOpponent(final Hero h, final int round) { // call Double Dispatch
        switch (h.getType()) {
            case 'K':
                accept(new Execute(h.getLevel()));
                accept(new Slam(h.getLevel()));
                break;
            case 'P':
                Pyromancer p = (Pyromancer) h;
                accept(new Fireblast(h.getLevel()));
                accept(new Ignite(h.getLevel(), p.overtimeDamage()));
                break;
            case 'R':
                Rogue r = (Rogue) h;
                accept(new Backstab(h.getLevel(), round));
                accept(new Paralysis(h.getLevel(), r.overtimeDamage()));
                break;
            case 'W':
                accept(new Drain(h.getLevel()));
                accept(new Deflect(h.getLevel(), h.getHp(), round));
                break;
            default:
                break;
        }
        this.setFight(true);

    }


    @Override
    public final String toString() {
        return getType() + " " + getLevel() + " " + getXp() + " " + getHp() + " "
                + getX() + " " + getY();
    }
}

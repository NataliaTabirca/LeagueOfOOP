package Hero;

public abstract class Hero {
    private int hp, xp, lvlHp;
    private int level;

    public Hero(int hp, int xp, int lvlHp) {
        this.hp = hp;
        this.xp = xp;
        this.lvlHp = lvlHp;
        this.level = 0;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public int getLvlHp() {
        return lvlHp;
    }
    public void setLvlHp(int lvlHp) {
        this.lvlHp = lvlHp;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp() {

        int lvl = 0;
        setLevel(lvl);
    }

    public void accept(AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
}

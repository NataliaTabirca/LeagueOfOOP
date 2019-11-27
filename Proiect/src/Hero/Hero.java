package Hero;

import Constants.Constants;

abstract class Hero {
    private int hp, xp, lvlHp;
    private int level;
    private int x, y;
    private MapType map;

    Hero(int hp, int xp, int lvlHp, int x, int y, MapType map) {
        this.hp = hp;
        this.xp = xp;
        this.lvlHp = lvlHp;
        this.level = 0;
        this.x = x;
        this.y = y;
        this.map = map;
    }

    private int getHp() {
        return hp;
    }
    void setHp(int hp) {
        this.hp = hp;
    }
    private int getXp() {
        return xp;
    }
    void setXp(int xp) {
        this.xp = xp;
    }
    int getLvlHp() {
        return lvlHp;
    }
    void setLvlHp(int lvlHp) {
        this.lvlHp = lvlHp;
    }
    private int getLevel() {
        return level;
    }
    private void setLevel(int level) {
        this.level = level;
    }

    void levelUp() {
        int xpLvlUp = Constants.BASE_XP + getLevel() * Constants.LVL_UP_MULT;
        while (getXp() - xpLvlUp >= 0) {
            setLevel(getHp() + 1);
            xpLvlUp += Constants.LVL_UP_MULT;
        }
        setLevel(getHp() - 1);
    }

    public void accept(AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }
}

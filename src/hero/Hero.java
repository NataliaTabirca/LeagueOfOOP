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
import angels.Angel;
import bonuses.AngelsVisitor;
import bonuses.DamageAngelVisit;
import bonuses.DarkAngelVisit;
import bonuses.DraculaVisit;
import bonuses.GoodBoyVisit;
import bonuses.LevelUpAngelVisit;
import bonuses.LifeGiverVisit;
import bonuses.SmallAngelVisit;
import bonuses.SpawnerVisit;
import bonuses.TheDoomerVisit;
import bonuses.XPAngelVisit;
import constants.Constants;
import fileio.FileSystem;
import main.Map;

import java.util.ArrayList;

public abstract class Hero implements Strategy, Subject {
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
    private ArrayList<Float> coefficient;
    private int index;

    public Hero() { }
    Hero(final int hp, final int xp, final int lvlHp, final int x, final int y) {
            this.hp = hp;
            this.xp = xp;
            this.lvlHp = lvlHp;
            this.level = 0;
            this.x = x;
            this.y = y;
            this.map = Map.getInstance().getMap().get(x).charAt(y);
            this.fight = false;
            this.move = true;
            this.roundsReceiveOTD = 0;
            this.odt = 0;
            this.alive = true;
            this.index = 0;
            this.coefficient = new ArrayList<>();
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
    public final ArrayList<Float> getCoefficient() {
        return coefficient;
    }
    public final void setCoefficient(final ArrayList<Float> coefficient) {
        this.coefficient = coefficient;
    }
    public final int getIndex() {
        return index;
    }
    public final void setIndex(final int index) {
        this.index = index;
    }

    public final String returnName() {
        switch (getType()) {
            case 'K':
                return "Knight";
            case 'P':
                return  "Pyromancer";
            case 'R':
                return "Rogue";
            case 'W':
                return  "Wizard";
            default:
                return "Hero";
        }
    }

    public final void levelUp(final FileSystem fs) {
        int xpLvlUp = Constants.BASE_XP + getLevel() * Constants.LVL_UP_MULT;
        while (getXp() - xpLvlUp >= 0) {
            setLevel(getLevel() + 1);
            notifyObserver(fs);
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
        if (getRoundsReceiveOTD() == 0) {  // if odt is gone
            setMove(true); // activate ability to move
        } else {
            if (round != 0) {  // do not apply odt if round = 0
                this.setHp(getHp() - getOdt());
                setRoundsReceiveOTD(getRoundsReceiveOTD() - 1);
            }
        }

        if (this.getHp() < 0) {  // if dead from odt
            this.setAlive(false);  // set dead
        }
    }


    public final void chooseStrategy() {
        float lowerLimit, upperLimit, atackHp, defenseHp, atackCoef, defenseCoef;
        int maxHp;
        switch (getType()) {
            case 'K':
                lowerLimit = Knight.LOWER_LIMIT;
                upperLimit = Knight.UPPER_LIMIT;
                atackCoef = Knight.ATACK_COEF_MOD;
                atackHp = Knight.ATACK_HP_MOD;
                defenseCoef = Knight.DEFENSE_COEF_MOD;
                defenseHp = Knight.DEFENSE_HP_MOD;
                maxHp = ((Knight) this).maxHp();
                break;
            case 'P':
                lowerLimit = Pyromancer.LOWER_LIMIT;
                upperLimit = Pyromancer.UPPER_LIMIT;
                maxHp = ((Pyromancer) this).maxHp();
                atackCoef = Pyromancer.ATACK_COEF_MOD;
                atackHp = Pyromancer.ATACK_HP_MOD;
                defenseCoef = Pyromancer.DEFENSE_COEF_MOD;
                defenseHp = Pyromancer.DEFENSE_HP_MOD;
                break;
            case 'R':
                lowerLimit = Rogue.LOWER_LIMIT;
                upperLimit = Rogue.UPPER_LIMIT;
                atackCoef = Rogue.ATACK_COEF_MOD;
                atackHp = Rogue.ATACK_HP_MOD;
                defenseCoef = Rogue.DEFENSE_COEF_MOD;
                defenseHp = Rogue.DEFENSE_HP_MOD;
                maxHp = ((Rogue) this).maxHp();
                break;
            case 'W':
                lowerLimit = Wizard.LOWER_LIMIT;
                upperLimit = Wizard.UPPER_LIMIT;
                atackCoef = Wizard.ATACK_COEF_MOD;
                atackHp = Wizard.ATACK_HP_MOD;
                defenseCoef = Wizard.DEFENSE_COEF_MOD;
                defenseHp = Wizard.DEFENSE_HP_MOD;
                maxHp = ((Wizard) this).maxHp();
                break;
            default:
                lowerLimit = 0f;
                upperLimit = 0f;
                atackCoef = 0f;
                atackHp = 0f;
                defenseCoef = 0f;
                defenseHp = 0f;
                maxHp = 0;
        }

        if (getHp() > Math.ceil(lowerLimit * maxHp) && getHp() <= Math.floor(upperLimit * maxHp)) {
            System.out.println(getType() + " chose atack");
            Strategy.atackStrategy(this, atackHp, atackCoef);
        } else {
            if (getHp() <= Math.floor(lowerLimit * maxHp) && getHp() > 0) {
                System.out.println(getType() + " chose defense");
                Strategy.defenseStrategy(this, defenseHp, defenseCoef);
               // System.out.println(getCoefficient());
            }
        }
    }

    public void accept(final AbilitiesVisitor abilitiesVisitor) {
        abilitiesVisitor.visit(this);
    }

    public final void fightOpponent(final Hero h, final int round) {
        switch (h.getType()) {
            case 'K':
                Knight k = (Knight) h;
                accept(new Execute(h.getLevel(), k.getCoefficient()));
                accept(new Slam(h.getLevel(), k.getCoefficient()));
                break;
            case 'P':
                Pyromancer p = (Pyromancer) h;
                accept(new Fireblast(h.getLevel(), p.getCoefficient()));
                accept(new Ignite(h.getLevel(), p.overtimeDamage(), p.getCoefficient()));
                break;
            case 'R':
                Rogue r = (Rogue) h;
                accept(new Backstab(h.getLevel(), round, r.getCoefficient()));
                accept(new Paralysis(h.getLevel(), r.overtimeDamage(), r.getCoefficient()));
                break;
            case 'W':
                Wizard w = (Wizard) h;
                accept(new Drain(h.getLevel(), w.getCoefficient()));
                accept(new Deflect(h.getLevel(), h.getHp(), round, w.getCoefficient()));
                break;
            default:
                break;
        }
        this.setFight(true);
        h.setFight(true);
    }

    public void accept(final AngelsVisitor angelsVisitor) {
        angelsVisitor.visit(this);
    }

    public final void angelsHelp(final Angel angel) {
        switch (angel.getName()) {
            case "DamageAngel":
                accept(new DamageAngelVisit());
                break;
            case "DarkAngel":
                accept(new DarkAngelVisit());
                break;
            case "Dracula":
                accept(new DraculaVisit());
                break;
            case "GoodBoy":
                accept(new GoodBoyVisit());
                break;
            case "LevelUpAngel":
                accept(new LevelUpAngelVisit());
                break;
            case "LifeGiver":
                accept(new LifeGiverVisit());
                break;
            case "SmallAngel":
                accept(new SmallAngelVisit());
                break;
            case "Spawner":
                accept(new SpawnerVisit());
                break;
            case "TheDoomer":
                accept(new TheDoomerVisit());
                break;
            case "XPAngel":
                accept(new XPAngelVisit());
                break;
            default:
                break;
        }
    }

    @Override
    public final void notifyObserver(final FileSystem fs, final Hero h) {
        TheGreatMagician.getInstance().update(fs, this, h);
    }

    @Override
    public final void notifyObserver(final FileSystem fs) {
        TheGreatMagician.getInstance().update(fs, this);
    }

    @Override
    public final  void notifyObserver(final FileSystem fs, final String msg, final Hero h) { }

    @Override
    public final String toString() {
        return getType() + " " + getLevel() + " " + getXp() + " " + getHp() + " "
                + getX() + " " + getY();
    }
}

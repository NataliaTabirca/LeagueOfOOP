package constants;

public final class Constants {
    private Constants() { }
    // initial hp
    public static final int KNIGHT_INIT_HP = 900;
    public static final int PIROMANCER_INIT_HP = 500;
    public static final int ROGUE_INIT_HP = 600;
    public static final int WIZARD_INIT_HP = 400;
    // hp/level
    public static final int KNIGHT_LVL_HP = 80;
    public static final int PIROMANCER_LVL_HP = 50;
    public static final int ROGUE_LVL_HP = 40;
    public static final int WIZARD_LVL_HP = 30;
    // level up
    public static final int BASE_XP = 250;
    public static final int LVL_UP_MULT = 50;

    // RACE AMPLIFIERS:
    //KNIGHT:
    public static final float EXECUTE_ROGUE = 1.15f;
    public static final float EXECUTE_KNIGHT = 1.0f;
    public static final float EXECUTE_PYROMANCER = 1.1f;
    public static final float EXECUTE_WIZARD = 0.8f;
    public static final float SLAM_ROGUE = 0.8f;
    public static final float SLAM_KNIGHT = 1.2f;
    public static final float SLAM_PYROMANCER = 0.9f;
    public static final float SLAM_WIZARD = 1.05f;
    // PYROMANCER
    public static final float FIREBLAST_ROGUE = 0.8f;
    public static final float FIREBLAST_KNIGHT = 1.2f;
    public static final float FIREBLAST_PYROMANCER = 0.9f;
    public static final float FIREBLAST_WIZARD = 1.05f;
    public static final float IGNITE_ROGUE = 0.8f;
    public static final float IGNITE_KNIGHT = 1.2f;
    public static final float IGNITE_PYROMANCER = 0.9f;
    public static final float IGNITE_WIZARD = 1.05f;
    // ROGUE
    public static final float BACKSTAB_ROGUE = 1.2f;
    public static final float BACKSTAB_KNIGHT = 0.9f;
    public static final float BACKSTAB_PYROMANCER = 1.25f;
    public static final float BACKSTAB_WIZARD = 1.25f;
    public static final float PARALISYS_ROGUE = 0.9f;
    public static final float PARALISYS_KNIGHT = 0.8f;
    public static final float PARALISYS_PYROMANCER = 1.2f;
    public static final float PARALISYS_WIZARD = 1.25f;

    // WIZARD
    public static final float DRAIN_ROGUE = 0.8f;
    public static final float DRAIN_KNIGHT = 1.2f;
    public static final float DRAIN_PYROMANCER = 0.9f;
    public static final float DRAIN_WIZARD = 1.05f;
    public static final float DEFLECT_ROGUE = 1.2f;
    public static final float DEFLECT_KNIGHT = 1.4f;
    public static final float DEFLECT_PYROMANCER = 1.3f;


    // map amplifiers
    public static final float DESERT = 1.1f;
    public static final float VOLCANIC = 1.25f;
    public static final float LAND = 1.15f;
    public static final float WOODS = 1.15f;
    public static final float ROGUE_CRITICAL = 1.5f;

    // base damage info
    // knight
    public static final int EXECUTE_BASE = 200;
    public static final int EXECUTE_LVL = 30;
    public static final int SLAM_BASE = 100;
    public static final int SLAM_LVL = 40;
    public static final float EXECUTE_HP_BASE = 0.2f;
    public static final float EXECUTE_HP_LVL = 0.01f;
    public static final float EXECUTE_HP_MAX = 0.4f;

    // rogue
    public static final int BACKSTAB_BASE = 200;
    public static final int BACKSTAB_LVL = 20;
    public static final int PARALISYS_BASE = 40;
    public static final int PARALISYS_LVL = 10;
    // pyromancer
    public static final int FIREBLAST_BASE = 350;
    public static final int FIREBLAST_LVL = 50;
    public static final int IGNITE_BASE = 150;
    public static final int IGNITE_LVL = 20;
    public static final int PYROMANCER_ODT = 50;
    public static final int PYROMANCER_ODT_LVL = 30;
    // wizard
    public static final float DEFLECT_BASE = 0.35f;
    public static final float DEFLECT_LVL = 0.02f;
    public static final float DEFLECT_MAX = 0.7f;
    public static final float DRAIN_BASE = 0.2f;
    public static final float DRAIN_LVL = 0.05f;
    public static final float DRAIN_HP_PER = 0.3f;

    public static final int THIRD_ROUND = 3;
    public static final int THREE_ROUNDS = 3;
    public static final int SIX_ROUNDS = 6;
    public static final int TWO_ROUNDS = 2;


    // xp
    public static final int MAX_XP_GAIN = 200;
    public static final int XP_GAIN = 40;
}

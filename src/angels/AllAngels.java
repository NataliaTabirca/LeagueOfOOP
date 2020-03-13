package angels;

import java.util.ArrayList;

public final class AllAngels {
    private static  AllAngels instance = null;
    private ArrayList<AngelsInRound> angels;

    private AllAngels(final ArrayList<AngelsInRound> angels) {
        this.angels = angels;
    }

    public static AllAngels getInstance(final ArrayList<AngelsInRound> value) {
        if (instance == null) {
            instance = new AllAngels(value);
        }
        return instance;
    }

    public static AllAngels getInstance() {
        return instance;
    }

    public ArrayList<AngelsInRound> getAngels() {
        return angels;
    }
}

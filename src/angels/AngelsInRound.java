package angels;

import java.util.ArrayList;

public final class AngelsInRound {
    private int number;
    private ArrayList<Angel> angels;

    public AngelsInRound(final int number) {
        this.number = number;
        this.angels = new ArrayList<>();
    }

    public AngelsInRound(final int number, final ArrayList<Angel> angels) {
        this.number = number;
        this.angels = angels;
    }

    public ArrayList<Angel> getAngels() {
        return angels;
    }
    public void setAngels(final ArrayList<Angel> angels) {
        this.angels = angels;
    }
}

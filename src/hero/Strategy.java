package hero;

public interface Strategy {
    int HUNDRED = 100;
    static void atackStrategy(final Hero h, final float hpMod, final float coefMod) {
        h.setHp(Math.round(h.getHp() - h.getHp() * hpMod));
        for (int i = 0; i < h.getCoefficient().size(); i++) {
            if (h.getCoefficient().get(i) != 1) {
                float newVal = h.getCoefficient().get(i) + coefMod;
                int aux = Math.round(newVal * HUNDRED);
                newVal = aux / (float) HUNDRED;
                h.getCoefficient().set(i, newVal);
            }
        }
    }

    static void defenseStrategy(final Hero h, final float hpMod, final float coefMod) {
        h.setHp(Math.round(h.getHp() + h.getHp() * hpMod));
        for (int i = 0; i < h.getCoefficient().size(); i++) {
            if (h.getCoefficient().get(i) != 1) {
                float newVal = h.getCoefficient().get(i) - coefMod;
                int aux = Math.round(newVal * HUNDRED);
                newVal = aux / (float) HUNDRED;
                h.getCoefficient().set(i, newVal);
            }
        }
    }

    void chooseStrategy();
}

package angels;

public final class AngelFactory {
    private AngelFactory() { }

    public static Angel createAngel(final String angelType, final int x, final int y) {
        switch (angelType) {
            case "DamageAngel":
                return new DamageAngel(angelType, x, y);
            case "DarkAngel":
                return new DarkAngel(angelType, x, y);
            case "Dracula":
                return new Dracula(angelType, x, y);
            case "GoodBoy":
                return new GoodBoy(angelType, x, y);
            case "LevelUpAngel":
                return new LevelUpAngel(angelType, x, y);
            case "LifeGiver":
                return new LifeGiver(angelType, x, y);
            case "SmallAngel":
                return new SmallAngel(angelType, x, y);
            case "Spawner":
                return new Spawner(angelType, x, y);
            case "TheDoomer":
                return new TheDoomer(angelType, x, y);
            case "XPAngel":
                return new XPAngel(angelType, x, y);
            default:
                return null;
        }
    }
}

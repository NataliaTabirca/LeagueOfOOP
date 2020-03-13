package hero;

public final class HeroFactory {
    private HeroFactory() { }

    public static Hero createHero(final String heroType, final int x, final int y) {
        switch (heroType) {
            case "K":
                return new Knight(x, y);
            case "P":
                return new Pyromancer(x, y);
            case "R":
                return new Rogue(x, y);
            case "W":
                return new Wizard(x, y);
            default:
                return null;
        }
    }
}

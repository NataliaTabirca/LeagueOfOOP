package angels;

import fileio.FileSystem;
import hero.Hero;
import hero.Subject;
import hero.TheGreatMagician;

import java.io.IOException;

public class Angel implements Subject {
    private String name;    // remember an angel by name
    private int x, y;       // and coords

    public Angel() { }

    public Angel(final String name, final int x, final int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public final String getName() {
        return name;
    }
    public final void setName(final String name) {
        this.name = name;
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

    @Override
    public final void notifyObserver(final FileSystem fs) {
        TheGreatMagician.getInstance().update(fs, this);
    }

    @Override
    public final void notifyObserver(final FileSystem fs, final String msg, final Hero h) {
        try {
            if (msg.equals("hit")) {
                fs.writeWord(getName() + " hit " + h.returnName() + " " + h.getIndex());
            } else {
                if (msg.equals("helped")) {
                    fs.writeWord(getName() + " helped " + h.returnName() + " " + h.getIndex());

                } else {
                    if (msg.equals("Spawner")) {
                        fs.writeWord("Player " + h.returnName() + " " + h.getIndex()
                                + " was brought to life by an angel");
                    } else {
                        fs.writeWord("Player " + h.returnName() + " " + h.getIndex()
                                + " was killed by an angel");
                    }

                }
            }
            fs.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public final void notifyObserver(final FileSystem fs, final Hero h) { }



    @Override
    public final String toString() {
        return  " " + name + " " + x + " " + y;
    }
}

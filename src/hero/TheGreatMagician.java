package hero;

import angels.Angel;
import fileio.FileSystem;

import java.io.IOException;

public final class TheGreatMagician implements Observer {
    private static TheGreatMagician instance = null;
    private TheGreatMagician() { }

    public static TheGreatMagician getInstance() {
        if (instance == null) {
            instance =  new TheGreatMagician();
        }
        return instance;
    }

    @Override
    public void update(final FileSystem fs, final Hero h1, final Hero h2) {
        try {
            String h = h1.returnName();
            String hh = h2.returnName();
            fs.writeWord("Player " + hh + " " + h2.getIndex() + " was killed by "
                    + h + " " + h1.getIndex());
            fs.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(final FileSystem fs, final Angel a) {
        try {
            fs.writeWord("Angel " + a.getName() + " was spawned at "
                    + a.getX() + " " + a.getY());
            fs.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(final FileSystem fs, final Hero h) {
        try {
            fs.writeWord(h.returnName() + " " + h.getIndex() + " reached level " + h.getLevel());
            fs.writeNewLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

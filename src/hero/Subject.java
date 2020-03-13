package hero;

import fileio.FileSystem;

public interface Subject {
    void notifyObserver(FileSystem fs, Hero h);
    void notifyObserver(FileSystem fs);
    void notifyObserver(FileSystem fs, String msg, Hero h);
}

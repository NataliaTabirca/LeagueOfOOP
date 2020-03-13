package hero;

import angels.Angel;
import fileio.FileSystem;

public interface Observer {
    void update(FileSystem fs, Hero h1, Hero h2);
    void update(FileSystem fs, Angel a);
    void update(FileSystem fs, Hero h);
}

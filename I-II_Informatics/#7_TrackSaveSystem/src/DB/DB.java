package DB;

import java.io.IOException;


public interface DB {
    void add(Object obj);
    void remove(int i);
    void readDBFromFile() throws DbException;
    void writeDBInFile() throws DbException;
}

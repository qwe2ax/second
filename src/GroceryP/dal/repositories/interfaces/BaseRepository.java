package GroceryP.dal.repositories.interfaces;

import GroceryP.entities.Apple;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BaseRepository<T> {
    void init();

    List<T> get() throws IOException;

    void add(int countOfApples) throws FileNotFoundException;

    void remove(int countOfApples) throws FileNotFoundException;
}

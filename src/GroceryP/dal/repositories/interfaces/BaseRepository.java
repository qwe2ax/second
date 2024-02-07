package GroceryP.dal.repositories.interfaces;

import GroceryP.entities.Apple;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BaseRepository<T> {
    void init();

    List<T> get() throws IOException;

    void add(int countOfProducts) throws FileNotFoundException;

    void changePrice(int newPrice) throws FileNotFoundException;

    void remove(int countOfProducts) throws FileNotFoundException;
}

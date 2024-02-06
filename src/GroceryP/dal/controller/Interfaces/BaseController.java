package GroceryP.dal.controller.Interfaces;

import GroceryP.entities.Apple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BaseController<T> {

    void init();
    List<T> get() throws IOException;

    void add(int countOfApples);

    void remove(int countOfApples);

}

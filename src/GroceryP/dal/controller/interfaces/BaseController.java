package GroceryP.dal.controller.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BaseController<T> {

    void init();

    List<T> get() throws IOException;

    void changePrice(int newPrice) throws FileNotFoundException;

    void add(int countOfProduct) throws FileNotFoundException;

    void remove(int countOfProduct) throws FileNotFoundException;

}

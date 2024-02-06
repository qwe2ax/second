package GroceryP.data.repositories.interfaces;

import GroceryP.entities.Apple;

import java.io.IOException;
import java.util.List;

public interface AppleRepository {

    void init();

    List<Apple> get() throws IOException;

    void add(int countOfApples);

    void remove(int countOfApples);


}

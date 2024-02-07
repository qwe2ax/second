package GroceryP.dal.repositories.implementations;

import GroceryP.dal.controller.implementations.AppleControllerImpl;
import GroceryP.dal.controller.interfaces.AppleController;
import GroceryP.dal.repositories.interfaces.AppleRepository;
import GroceryP.entities.Apple;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppleRepositoryImpl implements AppleRepository {

    List<Apple> applesList;

    AppleController appleController = new AppleControllerImpl<>();


    @Override
    public void init() {
        appleController.init();
    }

    @Override
    public List get() throws IOException {
        return appleController.get();
    }

    @Override
    public void add(int countOfApples) throws FileNotFoundException {
        appleController.add(countOfApples);
    }

    @Override
    public void changePrice(int newPrice) throws FileNotFoundException {
        appleController.changePrice(newPrice);
    }

    @Override
    public void remove(int countOfApples) throws FileNotFoundException {
        appleController.remove(countOfApples);
    }
}

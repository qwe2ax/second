package GroceryP.dal.repositories.implementations;

import GroceryP.dal.controller.Implements.AppleControllerImpl;
import GroceryP.dal.controller.Interfaces.AppleController;
import GroceryP.dal.repositories.interfaces.AppleRepository;
import GroceryP.entities.Apple;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppleRepositoryImpl implements AppleRepository {

    List<Apple> applesList;

    AppleController appleController = new AppleControllerImpl<>();

    public AppleRepositoryImpl() throws FileNotFoundException {
        applesList = new ArrayList<>();
    }


    @Override
    public void init() {
        appleController.init();
    }

    @Override
    public List get() throws IOException {
        return appleController.get();
    }

    @Override
    public void add(int countOfApples) {
        appleController.add(countOfApples);
    }

    @Override
    public void remove(int countOfApples) {
        appleController.remove(countOfApples);
    }
}

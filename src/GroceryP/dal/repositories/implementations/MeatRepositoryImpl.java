package GroceryP.dal.repositories.implementations;

import GroceryP.dal.controller.implementations.AppleControllerImpl;
import GroceryP.dal.controller.implementations.MeatControllerImpl;
import GroceryP.dal.controller.interfaces.AppleController;
import GroceryP.dal.controller.interfaces.MeatController;
import GroceryP.dal.repositories.interfaces.MeatRepository;
import GroceryP.entities.Apple;
import GroceryP.entities.Meat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MeatRepositoryImpl implements MeatRepository {

    List<Meat> meatList;

    MeatController meatController = new MeatControllerImpl<>();

    @Override
    public void init() {
        meatController.init();
    }

    @Override
    public List get() throws IOException {
        return meatController.get();
    }

    @Override
    public void add(int countOfMeat) throws FileNotFoundException {
        meatController.add(countOfMeat);
    }

    @Override
    public void remove(int countOfMeat) throws FileNotFoundException {
        meatController.remove(countOfMeat);
    }
}

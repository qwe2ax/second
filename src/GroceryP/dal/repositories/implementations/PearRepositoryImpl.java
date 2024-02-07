package GroceryP.dal.repositories.implementations;

import GroceryP.dal.controller.implementations.PearControllerImpl;
import GroceryP.dal.controller.interfaces.PearController;
import GroceryP.dal.repositories.interfaces.PearRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PearRepositoryImpl implements PearRepository {

    PearController pearController = new PearControllerImpl<>();

    @Override
    public void init() {
        pearController.init();
    }

    @Override
    public List get() throws IOException {
        return pearController.get();
    }

    @Override
    public void add(int countOfProducts) throws FileNotFoundException {
        pearController.add(countOfProducts);
    }

    @Override
    public void changePrice(int newPrice) {

    }

    @Override
    public void remove(int countOfProducts) throws FileNotFoundException {
        pearController.remove(countOfProducts);
    }
}

package GroceryP.dal.repositories.implementations;

import GroceryP.dal.controller.implementations.TomatoControllerImpl;
import GroceryP.dal.controller.interfaces.TomatoController;
import GroceryP.dal.repositories.interfaces.TomatoRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TomatoRepositoryImpl implements TomatoRepository {

    TomatoController tomatoController = new TomatoControllerImpl<>();

    @Override
    public void init() {
        tomatoController.init();
    }

    @Override
    public List get() throws IOException {
        return tomatoController.get();
    }

    @Override
    public void add(int countOfProducts) throws FileNotFoundException {
        tomatoController.add(countOfProducts);
    }

    @Override
    public void changePrice(int newPrice) {

    }

    @Override
    public void remove(int countOfProducts) throws FileNotFoundException {
        tomatoController.remove(countOfProducts);
    }
}

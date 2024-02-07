package GroceryP.dal.repositories.implementations;

import GroceryP.dal.controller.implementations.MilkControllerImpl;
import GroceryP.dal.controller.interfaces.MilkController;
import GroceryP.dal.repositories.interfaces.MilkRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class MilkRepositoryImpl implements MilkRepository {

    MilkController milkController = new MilkControllerImpl<>();
    @Override
    public void init() {
        milkController.init();
    }

    @Override
    public List get() throws IOException {
        return milkController.get();
    }

    @Override
    public void add(int countOfMilkCartons) throws FileNotFoundException {
        milkController.add(countOfMilkCartons);
    }

    @Override
    public void changePrice(int newPrice) {

    }

    @Override
    public void remove(int countOfMilkCartons) throws FileNotFoundException {
        milkController.remove(countOfMilkCartons);
    }
}

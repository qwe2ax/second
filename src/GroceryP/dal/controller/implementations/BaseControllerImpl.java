package GroceryP.dal.controller.implementations;

import GroceryP.dal.controller.interfaces.BaseController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class BaseControllerImpl<T> implements BaseController {


    public List<T> products = new ArrayList<>();


    private static final String fileName = "yabloki.txt";
    private final File storage = new File(fileName);


    public BaseControllerImpl() throws FileNotFoundException {
    }


    @Override
    public void init() {

    }

    @Override
    public List<T> get() throws IOException {
        return products;
    }

    @Override
    public void add(int countOfApples) {

    }

    @Override
    public void remove(int countOfApples) {

    }


}

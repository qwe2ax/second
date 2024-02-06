package GroceryP.data.controller.Implements;

import GroceryP.data.controller.Interfaces.BaseController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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

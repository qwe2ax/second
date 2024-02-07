package GroceryP.dal.controller.implementations;

import GroceryP.FileManager;
import GroceryP.dal.controller.interfaces.MilkController;
import GroceryP.entities.Meat;
import GroceryP.entities.Milk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MilkControllerImpl<T> implements MilkController {
    List<T> milkL = new ArrayList();

    List<Milk> milkList = new ArrayList<>();


    public static Milk milk = null;
    FileManager fileManager = new FileManager();
    private static final String fileName = "products.txt";
    private final File storage = new File(fileName);


    @Override
    public void init() {
        try {
            milk = new Milk(fileManager.priceChanger("Молоко"), "Молоко",
                    fileManager.storageChanger("Молоко"));
            if (!milkList.isEmpty()) {
                milkList.clear();
            }
            milkList.add(milk);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List get() throws IOException {
        if (!milkList.isEmpty()) {
            return milkList;
        }
        Scanner scanner = new Scanner(storage);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.contains("Молоко")) {
                milkL.add((T) s);
                return milkL;
            }
        }
        return null;
    }

    @Override
    public void changePrice(int newPrice) {

    }

    @Override
    public void add(int count) throws FileNotFoundException {
        milk.setStorage(milk.getStorage() + count);
        fileManager.updateFile(milkList);
    }

    @Override
    public void remove(int count) throws FileNotFoundException {
        if (milk.getStorage() - count < 0) {
            milk.setStorage(0);
            fileManager.updateFile(milkList);
        }
        else {
            milk.setStorage(milk.getStorage() - count);
            fileManager.updateFile(milkList);
        }
    }
}

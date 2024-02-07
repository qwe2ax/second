package GroceryP.dal.controller.implementations;

import GroceryP.FileManager;
import GroceryP.dal.controller.interfaces.MeatController;
import GroceryP.entities.Apple;
import GroceryP.entities.Meat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeatControllerImpl<T> implements MeatController {

    List<T> mea = new ArrayList();

    List<Meat> meatList = new ArrayList<>();


    public static Meat meat = null;
    FileManager fileManager = new FileManager();
    private static final String fileName = "products.txt";
    private final File storage = new File(fileName);


    @Override
    public void init() {
        try {
            meat = new Meat(fileManager.priceChanger("Мясо"), "Мясо",
                    fileManager.storageChanger("Мясо"));
            if (!meatList.isEmpty()) {
                meatList.clear();
            }
            meatList.add(meat);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List get() throws IOException {
        Scanner scanner = new Scanner(storage);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.contains("Мясо")) {
                mea.add((T) s);
                return mea;
            }
        }
        return null;
    }

    @Override
    public void add(int countOfApples) throws FileNotFoundException {
        meat.setStorage(meat.getStorage() + countOfApples);
        fileManager.updateFile(meatList);
    }

    @Override
    public void remove(int countOfMeat) throws FileNotFoundException {
        if (meat.getStorage() - countOfMeat < 0) {
            meat.setStorage(0);
            fileManager.updateFile(meatList);
        }
        else {
            meat.setStorage(meat.getStorage() - countOfMeat);
            fileManager.updateFile(meatList);
        }
    }
}

package GroceryP.dal.controller.implementations;

import GroceryP.FileManager;
import GroceryP.dal.controller.interfaces.MeatController;
import GroceryP.entities.Meat;

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



    @Override
    public void init() {
        try {
            meat = new Meat(fileManager.priceChecker("Мясо"), "Мясо",
                    fileManager.storageChecker("Мясо"));
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
        if (!mea.isEmpty()) {
            return mea;
        }
        Scanner scanner = new Scanner(FileManager.storage);
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
    public void changePrice(int newPrice) throws FileNotFoundException {
        meat.setPrice(newPrice);
        fileManager.updateFile(meatList);
    }

    @Override
    public void add(int count) throws FileNotFoundException {
        meat.setStorage(meat.getStorage() + count);
        fileManager.updateFile(meatList);
    }

    @Override
    public void remove(int count) throws FileNotFoundException {
        if (meat.getStorage() - count < 0) {
            meat.setStorage(0);
            fileManager.updateFile(meatList);
        }
        else {
            meat.setStorage(meat.getStorage() - count);
            fileManager.updateFile(meatList);
        }
    }
}

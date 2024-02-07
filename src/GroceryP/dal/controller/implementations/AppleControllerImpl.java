package GroceryP.dal.controller.implementations;

import GroceryP.FileManager;
import GroceryP.dal.controller.interfaces.AppleController;
import GroceryP.entities.Apple;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppleControllerImpl<T> implements AppleController {

    List<T> ap = new ArrayList();

    List<Apple> appleList = new ArrayList<>();


    public static Apple apple = null;
    FileManager fileManager = new FileManager();


    @Override
    public void init() {
        try {
            apple = new Apple(fileManager.priceChecker("Яблоко"), "Яблоко",
                    fileManager.storageChecker("Яблоко"));
            if (!appleList.isEmpty()) {
                appleList.clear();
            }
            appleList.add(apple);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> get() throws IOException {
        if (!ap.isEmpty()) {
            return ap;
        }
        Scanner scanner = new Scanner(FileManager.storage);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.contains("Яблоко")) {
                ap.add((T) s);
                return ap;
            }
        }
        return null;
    }

    @Override
    public void changePrice(int newPrice) throws FileNotFoundException {
        apple.setPrice(newPrice);
        fileManager.updateFile(appleList);
    }

    @Override
    public void add(int count) throws FileNotFoundException {
        apple.setStorage(apple.getStorage() + count);
        fileManager.updateFile(appleList);
    }

    @Override
    public void remove(int count) throws FileNotFoundException {
        if (apple.getStorage() - count <= 0) {
            apple.setStorage(0);
            fileManager.updateFile(appleList);
        }
        else {
            apple.setStorage(apple.getStorage() - count);
            fileManager.updateFile(appleList);
        }
    }
}

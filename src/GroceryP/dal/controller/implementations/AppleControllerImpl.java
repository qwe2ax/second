package GroceryP.dal.controller.implementations;

import GroceryP.FileManager;
import GroceryP.dal.controller.interfaces.AppleController;
import GroceryP.entities.Apple;

import java.io.File;
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
    private static final String fileName = "products.txt";
    private final File storage = new File(fileName);

    @Override
    public void init() {
        try {
            apple = new Apple(fileManager.priceChanger("Яблоко"), "Яблоко",
                    fileManager.storageChanger("Яблоко"));
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
        Scanner scanner = new Scanner(storage);
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
    public void add(int countOfApples) throws FileNotFoundException {
        apple.setStorage(apple.getStorage() + countOfApples);
        fileManager.updateFile(appleList);
    }

    @Override
    public void remove(int countOfApples) throws FileNotFoundException {
        if (apple.getStorage() - countOfApples <= 0) {
            apple.setStorage(0);
            fileManager.updateFile(appleList);
        }
        else {
            apple.setStorage(apple.getStorage() - countOfApples);
            fileManager.updateFile(appleList);
        }
    }
}

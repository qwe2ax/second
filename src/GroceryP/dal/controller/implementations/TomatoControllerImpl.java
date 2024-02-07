package GroceryP.dal.controller.implementations;

import GroceryP.FileManager;
import GroceryP.dal.controller.interfaces.TomatoController;
import GroceryP.entities.Tomato;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TomatoControllerImpl<T> implements TomatoController {
    List<T> productList = new ArrayList();

    List<Tomato> tomatoList = new ArrayList<>();

    public static Tomato tomato = null;
    FileManager fileManager = new FileManager();


    @Override
    public void init() {
        try {
            tomato = new Tomato(fileManager.priceChecker("Помидор"), "Помидор",
                    fileManager.storageChecker("Помидор"));
            if (!tomatoList.isEmpty()) {
                tomatoList.clear();
            }
            tomatoList.add(tomato);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List get() throws IOException {
        Scanner scanner = new Scanner(FileManager.storage);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.contains("Помидор")) {
                productList.add((T) s);
                return productList;
            }
        }
        return null;
    }

    @Override
    public void changePrice(int newPrice) throws FileNotFoundException {
        tomato.setPrice(newPrice);
        fileManager.updateFile(tomatoList);
    }

    @Override
    public void add(int count) throws FileNotFoundException {
        tomato.setStorage(tomato.getStorage() + count);
        fileManager.updateFile(tomatoList);
    }

    @Override
    public void remove(int count) throws FileNotFoundException {
        if (tomato.getStorage() - count < 0) {
            tomato.setStorage(0);
            fileManager.updateFile(tomatoList);
        } else {
            tomato.setStorage(tomato.getStorage() - count);
            fileManager.updateFile(tomatoList);
        }
    }
}

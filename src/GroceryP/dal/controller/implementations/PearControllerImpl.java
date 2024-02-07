package GroceryP.dal.controller.implementations;

import GroceryP.FileManager;
import GroceryP.dal.controller.interfaces.PearController;
import GroceryP.entities.Pear;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PearControllerImpl<T> implements PearController {
    List<T> pearL = new ArrayList();

    List<Pear> pearList = new ArrayList<>();

    public static Pear pear = null;
    FileManager fileManager = new FileManager();


    @Override
    public void init() {
        try {
            pear = new Pear(fileManager.priceChecker("Груша"), "Груша",
                    fileManager.storageChecker("Груша"));
            if (!pearList.isEmpty()) {
                pearList.clear();
            }
            pearList.add(pear);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List get() throws IOException {
        Scanner scanner = new Scanner(FileManager.storage);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.contains("Груша")) {
                pearL.add((T) s);
                return pearL;
            }
        }
        return null;
    }

    @Override
    public void changePrice(int newPrice) throws FileNotFoundException {
        pear.setPrice(newPrice);
        fileManager.updateFile(pearList);
    }

    @Override
    public void add(int count) throws FileNotFoundException {
        pear.setStorage(pear.getStorage() + count);
        fileManager.updateFile(pearList);
    }

    @Override
    public void remove(int count) throws FileNotFoundException {
        if (pear.getStorage() - count < 0) {
            pear.setStorage(0);
            fileManager.updateFile(pearList);
        } else {
            pear.setStorage(pear.getStorage() - count);
            fileManager.updateFile(pearList);
        }
    }
}

package GroceryP.logic;

import GroceryP.FileManager;
import GroceryP.dal.repositories.implementations.AppleRepositoryImpl;
import GroceryP.dal.repositories.interfaces.AppleRepository;
import GroceryP.entities.Apple;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static AppleRepository appleRepository;

    static {
        try {
            appleRepository = new AppleRepositoryImpl();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static FileManager fileManager = new FileManager();

    public static void main(String[] args) throws IOException {
        appleRepository.init();
        appleRepository.remove(3);
        System.out.println(appleRepository.get());
    }
}

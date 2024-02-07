package GroceryP.logic;

import GroceryP.FileManager;
import GroceryP.dal.repositories.implementations.AppleRepositoryImpl;
import GroceryP.dal.repositories.implementations.MeatRepositoryImpl;
import GroceryP.dal.repositories.interfaces.AppleRepository;
import GroceryP.dal.repositories.interfaces.MeatRepository;
import GroceryP.entities.Apple;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static AppleRepository appleRepository; static MeatRepository meatRepository;

    static {
        appleRepository = new AppleRepositoryImpl();
        meatRepository = new MeatRepositoryImpl();
    }

    static FileManager fileManager = new FileManager();

    public static void main(String[] args) throws IOException {
        meatRepository.init();
        meatRepository.remove(2);
        System.out.println(meatRepository.get());
    }
}

package GroceryP.logic;

import GroceryP.FileManager;
import GroceryP.dal.repositories.implementations.*;
import GroceryP.dal.repositories.interfaces.*;
import GroceryP.entities.Apple;
import GroceryP.util.UtilStrings;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static AppleRepository appleRepository;
    static MeatRepository meatRepository;
    static TomatoRepository tomatoRepository;
    static PearRepository pearRepository;
    static MilkRepository milkRepository;

    static {
        appleRepository = new AppleRepositoryImpl();
        meatRepository = new MeatRepositoryImpl();
        milkRepository = new MilkRepositoryImpl();
        pearRepository = new PearRepositoryImpl();
        tomatoRepository = new TomatoRepositoryImpl();
        meatRepository.init();
        appleRepository.init();
        pearRepository.init();
        tomatoRepository.init();
        milkRepository.init();
    }

    static FileManager fileManager = new FileManager();

    static UtilStrings utilStrings = new UtilStrings();

    public static void main(String[] args) throws IOException {
        System.out.println(utilStrings.sumOfProduct("Яблоко"));
        appleRepository.changePrice(100);
        fileManager.updateFile(appleRepository.get());
        System.out.println(appleRepository.get());
    }
}

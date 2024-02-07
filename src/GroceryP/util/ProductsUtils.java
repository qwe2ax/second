package GroceryP.util;

import GroceryP.FileManager;
import GroceryP.dal.repositories.implementations.*;
import GroceryP.dal.repositories.interfaces.*;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ProductsUtils {

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
    }

    FileManager fileManager = new FileManager();

    public static void init() {
        meatRepository.init();
        appleRepository.init();
        pearRepository.init();
        tomatoRepository.init();
        milkRepository.init();

    }
    public String purchase(String nameOfProduct) throws IOException {
        if (fileManager.storageChecker(nameOfProduct) <= 0 ) {
            return String.format("Недостаточное количество продукта %s на складе", nameOfProduct);
        }

        switch (nameOfProduct.toLowerCase()) {
            case "яблоко":
                appleRepository.remove(1);
                fileManager.updateFile(appleRepository.get());
                return String.format("Вы купили %s стоимостью %d", nameOfProduct, fileManager.priceChecker(nameOfProduct));
            case "молоко":
                milkRepository.remove(1);
                fileManager.updateFile(milkRepository.get());
                return String.format("Вы купили %s стоимостью %d", nameOfProduct, fileManager.priceChecker(nameOfProduct));
            case "мясо":
                meatRepository.remove(1);
                fileManager.updateFile(meatRepository.get());
                return String.format("Вы купили %s стоимостью %d", nameOfProduct, fileManager.priceChecker(nameOfProduct));
            case "груша":
                pearRepository.remove(1);
                fileManager.updateFile(pearRepository.get());
                return String.format("Вы купили %s стоимостью %d", nameOfProduct, fileManager.priceChecker(nameOfProduct));
            case "помидор":
                tomatoRepository.remove(1);
                fileManager.updateFile(tomatoRepository.get());
                return String.format("Вы купили %s стоимостью %d", nameOfProduct, fileManager.priceChecker(nameOfProduct));
        }
        return "Продукт не найден";
    }

    public String priceChanger(String nameOfProduct, int newPrice) throws IOException {
        switch (nameOfProduct.toLowerCase()) {
            case "яблоко":
                appleRepository.changePrice(newPrice);
                return String.format("Цена продукта %s изменена на %d", nameOfProduct, newPrice);
            case "молоко":
                milkRepository.changePrice(newPrice);
                return String.format("Цена продукта %s изменена на %d", nameOfProduct, newPrice);
            case "мясо":
                meatRepository.changePrice(newPrice);
                return String.format("Цена продукта %s изменена на %d", nameOfProduct, newPrice);
            case "груша":
                pearRepository.changePrice(newPrice);
                return String.format("Цена продукта %s изменена на %d", nameOfProduct, newPrice);
            case "помидор":
                tomatoRepository.changePrice(newPrice);
                return String.format("Цена продукта %s изменена на %d", nameOfProduct, newPrice);
        }
        return "Продукт не найден";
    }

    public String storageChanger(String nameOfProduct, int countOfProduct) throws IOException {
        switch (nameOfProduct.toLowerCase()) {
            case "яблоко":
                appleRepository.add(countOfProduct);
                fileManager.updateFile(appleRepository.get());
                return String.format("Текущее кол-во %s равно %d", nameOfProduct, fileManager.storageChecker(nameOfProduct));
            case "молоко":
                milkRepository.add(countOfProduct);
                fileManager.updateFile(milkRepository.get());
                return String.format("Текущее кол-во %s равно %d", nameOfProduct, fileManager.storageChecker(nameOfProduct));
            case "мясо":
                meatRepository.add(countOfProduct);
                fileManager.updateFile(meatRepository.get());
                return String.format("Текущее кол-во %s равно %d", nameOfProduct, fileManager.storageChecker(nameOfProduct));
            case "груша":
                pearRepository.add(countOfProduct);
                fileManager.updateFile(pearRepository.get());
                return String.format("Текущее кол-во %s равно %d", nameOfProduct, fileManager.storageChecker(nameOfProduct));
            case "помидор":
                tomatoRepository.add(countOfProduct);
                fileManager.updateFile(tomatoRepository.get());
                return String.format("Текущее кол-во %s равно %d", nameOfProduct, fileManager.storageChecker(nameOfProduct));
        }
        return "Продукт не найден";
    }

}

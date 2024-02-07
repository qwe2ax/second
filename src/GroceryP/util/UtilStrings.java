package GroceryP.util;

import GroceryP.entities.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UtilStrings {

    static File storage = new File("products.txt");

    public void printMenu() {
        System.out.println("Меню действий:\n" + "1. Купить товар\n" +
                "2. Посмотреть каталог\n" + "3. Изменить цену\n" +
                "4. Посмотреть кассу\n" +
                "5. Склад\n" +
                "0. Выход");
    }

    public String sumOfAllProducts() throws FileNotFoundException {
        Scanner scanner = new Scanner(storage);
        long sum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] ar = line.split("\\D+");
            sum += (long) Integer.parseInt(ar[1]) * Integer.parseInt(ar[2]);
        }
        return String.format("Общая стоимость всех продуктов равна %dр", sum);
    }

    public String sumOfProduct(String productName) throws FileNotFoundException {
        Scanner scanner = new Scanner(storage);
        long sum;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(productName)) {
                String[] ar = line.split("\\D+");
                sum = (long) Integer.parseInt(ar[1]) * Integer.parseInt(ar[2]);
                return String.format("Общая стоимость продукта %s равна %dр", productName, sum);
            }
        }
        return "Товар не найден";
    }
}

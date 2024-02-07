package GroceryP.logic;

import GroceryP.FileManager;
import GroceryP.dal.repositories.implementations.*;
import GroceryP.dal.repositories.interfaces.*;
import GroceryP.util.ProductsUtils;
import GroceryP.util.StringUtils;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static FileManager fileManager = new FileManager();

    static StringUtils stringUtils = new StringUtils();

    static ProductsUtils productsUtils = new ProductsUtils();

    public static void main(String[] args) throws IOException {
        ProductsUtils.init();
        int cashRegister = 0;
        System.out.println(fileManager.printProductList());
        stringUtils.printMenu();
        Scanner console = new Scanner(System.in);
        int menuNum = console.nextInt();

        while (true) {
            switch (menuNum) {
                case 1:
                    System.out.println("Введите название товара");
                    String productName0 = console.next();
                    String resultOfPurchase = productsUtils.purchase(productName0);
                    System.out.println(resultOfPurchase);
                    if (!resultOfPurchase.equalsIgnoreCase(String.format("Недостаточное количество продукта %s на складе", productName0))
                            && !resultOfPurchase.equalsIgnoreCase("Продукт не найден")) {
                        cashRegister += cashCounter(resultOfPurchase.split("\\D"));
                    }
                    break;
                case 2:
                    System.out.println("Каталог товаров:");
                    fileManager.printProductList();
                    break;
                case 3:
                    System.out.println("Введите название товара:");
                    String productName = console.next();
                    System.out.println("Введите новую цену:");
                    int newPrice = console.nextInt();
                    System.out.println(productsUtils.priceChanger(productName, newPrice));
                    break;
                case 4:
                    System.out.println("Счёт за товары равен " + cashRegister + "р");
                    break;
                case 5:
                    System.out.println("Действия со складом:\n" +
                            "1. Посмотреть склад\n" +
                            "2. Добавить продукт\n" +
                            "3. Посчитать общую стоимость продукта\n" +
                            "4. Посчитать общую стоимость всех продуктов\n" +
                            "0. Выйти");
                    int action = console.nextInt();
                    switch (action) {
                        case 1:
                            fileManager.printProductList();
                            break;
                        case 2:
                            System.out.println("Введите название продукта:");
                            String productName2 = console.next();
                            System.out.println("Введите количество добавляемых продуктов:");
                            int addedProducts = console.nextInt();
                            System.out.println(productsUtils.storageChanger(productName2, addedProducts));
                            break;
                        case 3:
                            System.out.println("Введите название продукта:");
                            String productName1 = console.next();
                            System.out.println(stringUtils.sumOfProduct(productName1));
                            break;
                        case 4:
                            System.out.println(stringUtils.sumOfAllProducts());
                            break;
                        default:
                            System.out.println("Неверный ввод");
                    }
                    break;
                case 0:
                    System.out.println("Программа завершила свою работу");
                    ProductsUtils.init();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод");

            }
            stringUtils.printMenu();
            menuNum = console.nextInt();
        }
    }



    public static int cashCounter(String[] num) {
        String result = num[num.length - 1];
        return Integer.parseInt(result);
    }

}

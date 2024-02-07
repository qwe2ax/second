package GroceryP;


import GroceryP.entities.Apple;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager<T> {

    static File storage = new File("products.txt");

    static Scanner scanner;

    static {
        try {
            scanner = new Scanner(storage);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateFile(List<T> someProduct) throws FileNotFoundException {
        StringBuilder res = new StringBuilder();
        Scanner scanner = new Scanner(storage);
        int i = 1;
        while (scanner.hasNextLine()) {
            String[] ar = someProduct.toString().toLowerCase().split(":");
            String str = scanner.nextLine();
            if (!str.toLowerCase().contains(ar[1])) {
                if (i == 4 && !str.isEmpty()) {
                    res.append(str);
                }
                else if (!str.isEmpty()) {
                    res.append(str).append("\n");
                }
            }
            i++;
        }
        try {
            PrintWriter printWriter = new PrintWriter(storage);
            printWriter.println(res);
            for (T product : someProduct) {
                printWriter.println(product);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int priceChanger(String product) throws IOException {
        product = product.toLowerCase();
        Scanner scanner = new Scanner(storage);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().toLowerCase();
            if (str.contains(product)) {
                String[] ar = str.split("\\D+");
                return Integer.parseInt(ar[1]);
            }
        }
        return -1;
    }

    public int storageChanger(String product) throws IOException {
        product = product.toLowerCase();
        Scanner scanner = new Scanner(storage);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine().toLowerCase();
            if (str.contains(product)) {
                String[] ar = str.split("\\D+");
                return Integer.parseInt(ar[2]);
            }
        }
        return -1;
    }
}

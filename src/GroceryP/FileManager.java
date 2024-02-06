package GroceryP;


import GroceryP.entities.Apple;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileManager<T> {

    File storage = new File("yabloki.txt");


    public void updateFile(List<T> someProduct) {
        try {
            PrintWriter printWriter = new PrintWriter(storage);
            for (T apple : someProduct) {
                printWriter.println(apple + "\n");
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int priceChanger(String product) throws IOException {
        Scanner scanner = new Scanner(storage);
        product = product.toLowerCase();
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

        Scanner scanner = new Scanner(storage);
        product = product.toLowerCase();
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

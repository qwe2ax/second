package GroceryP;


import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileManager<T> {

    public static final File storage = new File("products.txt");

    public void updateFile(List<T> someProduct) throws FileNotFoundException {
        StringBuilder res = new StringBuilder();
        Scanner scanner = new Scanner(storage);
        int i = 1;
        while (scanner.hasNextLine()) {
            String[] ar = someProduct.toString().toLowerCase().split(":");
            String str = scanner.nextLine();
            if (!str.toLowerCase().contains(ar[1])) {
                if (!str.isEmpty()) {
                    res.append("\n").append(str);
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

    public int priceChecker(String product) throws IOException {
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

    public int storageChecker(String product) throws IOException {
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

    public String printProductList() throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(storage);
        while (scanner.hasNextLine()) {
            result.append(scanner.nextLine()).append("\n");
        }
        return result.toString();
    }
}

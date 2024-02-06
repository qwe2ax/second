package GroceryP.entities;

public class Apple {
    int price;

    String productName;

    int storage;

    public Apple(int price, String productName, int storage) {
        this.price = price;
        this.productName = productName;
        this.storage = storage;
    }

    public int getPrice() {
        return price;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Название товара: " + productName +
                ", Стоимость: " + price +
                ", Количество на складе: " + storage + "\n";
    }
}

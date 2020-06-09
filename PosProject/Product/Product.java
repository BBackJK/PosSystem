package PosProject.Product;

public class Product {
    private String name;
    private int price;
    private String code;
    private int number;

    public Product(String name, int price, String code, int number) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public String getCode() {
        return this.code;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean nameEquals(String name) {
        if (name.equals(this.name)) {
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println("상품명: " + this.name + ", 가격: " + this.price + ", 수량: " + this.number);
    }
}
package product_management_v02;

import java.util.Scanner;

public class product {
    private String productID;
    private String productName;
    private double amount;
    private double price;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public product(String productID, String productName, double amount, double price) {
        this.productID = productID;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
    }

    public product(){}

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product id: ");
        productID = sc.nextLine();

        System.out.print("Enter product name: ");
        productName = sc.nextLine();

        System.out.print("Enter amount: ");
        amount = sc.nextDouble();

        System.out.print("Enter price: ");
        price = sc.nextDouble();
    }

    public void output(){
        System.out.println("Product id: " + productID + "\nProduct name: " + productName + "\nAmount: " + amount + "\nPrice: " + price);
    }
}

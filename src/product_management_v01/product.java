package product_management_v01;

import java.util.Scanner;

public class product {
    private String productName;
    private String producer;
    private double price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public product(String productName, String producer, double price) {
        this.productName = productName;
        this.producer = producer;
        this.price = price;
    }

    public product (){}

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ex_01.product name: ");
        productName = sc.nextLine();

        System.out.print("Enter producer: ");
        producer = sc.nextLine();

        System.out.print("Enter price: ");
        price = sc.nextDouble();
    }

    public void output(){
        System.out.println("Product name: " + productName + "\nProducer: " + producer + "\nPrice: " + price);
    }

    public void sort(product[] p){
        for(int i = 0; i< p.length - 1; i++){
            for(int j = i+1; j < p.length; j++){
                if(p[i].price > p[j].price){
                    product temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }
}

package electric_bill_management;

import java.util.Date;
import java.util.Scanner;

public class AbroadCustomer extends Customer {
    private String national;

    public AbroadCustomer(String customerId, String customerName, Date billDate, int amount, double price, String national) {
        super(customerId, customerName, billDate, amount, price);
        this.national = national;
    }

    public AbroadCustomer(){}

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public double intoMoney() {
        return amount * price;
    }

    public void inputAbroadCustomer() {
        super.inputCustomer();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.print("\n\t\tEnter the national customer: ");
        this.national = sc.nextLine();
    }

    public void showAbroadCustomer(){
        super.showCustomer();
        double money = intoMoney();
        System.out.printf("|%14s|%14s|%n", national, money);
        System.out.print("+---------------+-------------------+-----------+--------+-----------+--------------+--------------+\n");
    }
}

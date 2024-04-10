package electric_bill_management;

import java.util.Date;
import java.util.Scanner;

public class VietnamCustomer extends Customer {
    private String customerType;
    private int quota;

    public VietnamCustomer(String customerId, String customerName, Date billDate, int amount, double price, String customerType, int quota) {
        super(customerId, customerName, billDate, amount, price);
        this.customerType = customerType;
        this.quota = quota;
    }

    public VietnamCustomer(){}

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public double intoMoney(){
        if(this.amount <= this.quota)
            return this.amount * this.price;
        else
            return amount*price*quota + (amount - quota)*price*2.5;
    }

    public void inputVietnamCustomer(){
        super.inputCustomer();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("\n\t\t1. Sinh hoat\n\t\t2. Kinh doanh\n\t\t3. San xuat\n\t\tYour choice: ");
            choice = sc.nextInt();
            if(choice < 1 || choice > 3)
                System.out.print("\n\tYour choice is invalid! Please try again!");
        }while(choice < 1 || choice > 3);
        switch(choice){
            case 1-> this.customerType = "Sinh hoạt";
            case 2-> this.customerType = "Kinh doanh";
            case 3-> this.customerType = "Sản xuất";
        }

        System.out.print("\t\tEnter quota: ");
        this.quota = sc.nextInt();
    }

    public void showVietnamCustomer(){
        super.showCustomer();
        double Money = intoMoney();
        System.out.printf("|%15s|%9s|%14s|%n", customerType, quota, Money);
        System.out.print("+---------------+-------------------+-----------+--------+-----------+---------------+---------+--------------+\n");
    }
}

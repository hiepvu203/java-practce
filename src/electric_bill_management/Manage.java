package electric_bill_management;

import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    private final ArrayList<Customer> customers = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public void inputCustomers(){
        int selection;
        do{
            System.out.print("\n\t1. Vietnam customer\n\t2. Abroad customer\n\t3. Exit\n");
            System.out.print("Your selection: ");
            selection = sc.nextInt();
            switch(selection){
                case 1 -> {
                    VietnamCustomer vn = new VietnamCustomer();
                    vn.inputVietnamCustomer();
                    customers.add(vn);
                }
                case 2 -> {
                    AbroadCustomer ab = new AbroadCustomer();
                    ab.inputAbroadCustomer();
                    customers.add(ab);
                }
                case 3 -> {}
                default -> System.out.println("Your selection is invalid!");
            }
        }while(selection != 3);
    }

    public static void vietnamHeader(){
        System.out.print("\n\n\t\t\t---- Vietnam list ---- \n");
        System.out.print("+---------------+-------------------+-----------+--------+-----------+---------------+---------+--------------+\n");
        System.out.print("|  Customer id  |   Customer name   | Bill date | Amount |   Price   | Customer type |  Quota  |  Into money  |\n");
        System.out.print("+---------------+-------------------+-----------+--------+-----------+---------------+---------+--------------+\n");
    }

    public static void abroadHeader(){
        System.out.print("\n\n\t\t\t---- Abroad list ---- \n");
        System.out.print("+---------------+-------------------+-----------+--------+-----------+--------------+--------------+\n");
        System.out.print("|  Customer id  |   Customer name   | Bill date | Amount |   Price   |   National   |  Into money  |\n");
        System.out.print("+---------------+-------------------+-----------+--------+-----------+--------------+--------------+\n");
    }
    
    public void showCustomers(){
        boolean VietnamHeaderPrinted = false;
        boolean AbroadHeaderPrinted = false;

        for (Customer customer : customers) {
            if (customer instanceof VietnamCustomer) {
                if (!VietnamHeaderPrinted) {
                    vietnamHeader();
                    VietnamHeaderPrinted = true;
                }
                ((VietnamCustomer) customer).showVietnamCustomer();
            } else if (customer instanceof AbroadCustomer) {
                if (!AbroadHeaderPrinted) {
                    abroadHeader();
                    AbroadHeaderPrinted = true;
                }
                ((AbroadCustomer) customer).showAbroadCustomer();
            }
        }
    }

    public void totalElectricConsumed(){
        long totalVietnam = 0;
        long totalAbroad = 0;

        for(Customer customer : customers) {
            if(customer instanceof VietnamCustomer)
                totalVietnam += customer.amount;
            else if(customer instanceof AbroadCustomer)
                totalAbroad += customer.amount;
        }

        System.out.print("\nTotal electric consumed of vietnam customer: " + totalVietnam);
        System.out.print("\nTotal electric consumed of abroad customer: " + totalAbroad);
    }

    public void calcAverageMoneyAbroadCustomer(){
        int count = 0;
        double totalMoney = 0;
        for (Customer customer : customers){
            if(customer instanceof AbroadCustomer){
                totalMoney += customer.intoMoney();
                count++;
            }
        }

        double average = totalMoney / count;
        System.out.println("\nCalculate average into money of abroad customer: " + average);
    }

    public void exportByDate(){
        boolean VietnamHeaderPrinted = false;
        boolean AbroadHeaderPrinted = false;

        for (Customer customer : customers) {
            if (customer instanceof VietnamCustomer) {
                if (!VietnamHeaderPrinted) {
                    vietnamHeader();
                    VietnamHeaderPrinted = true;
                }
                if(customer.getMonth() == 9 && customer.getYear() == 2013)
                    ((VietnamCustomer) customer).showVietnamCustomer();
            } else if (customer instanceof AbroadCustomer) {
                if (!AbroadHeaderPrinted) {
                    abroadHeader();
                    AbroadHeaderPrinted = true;
                }
                if(customer.getMonth() == 9 && customer.getYear() == 2013)
                    ((AbroadCustomer) customer).showAbroadCustomer();
            }
        }
    }

    public static void menu(){
        System.out.print("""
                \t\t1. Enter and export customer bills.
                \t\t2. Total electricity consumption for each type of customer.
                \t\t3. Calculate the average amount of money for foreign customers.
                \t\t4. Export invoices in September 2013 (of 2 types of customers).
                \t\t5. Exit
                """);
    }

    public static void main(String[] args) {
        Manage mg = new Manage();
        int selection;
        do{
            menu();
            System.out.print("Your selection: ");
            selection = sc.nextInt();
            switch(selection){
                case 1 -> {
                    mg.inputCustomers();
                    mg.showCustomers();
                }
                case 2 -> mg.totalElectricConsumed();
                case 3 -> mg.calcAverageMoneyAbroadCustomer();
                case 4 -> mg.exportByDate();
                case 5 -> {}
                default -> System.out.println("Your selection is invalid!");
            }
        }while(selection != 5);
    }
}
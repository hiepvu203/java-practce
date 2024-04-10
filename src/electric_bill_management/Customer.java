package electric_bill_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public abstract class Customer {
    protected String customerId, customerName;
    protected Date billDate;
    protected int amount;
    protected double price;

    public Customer(String customerId, String customerName, Date billDate, int amount, double price) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.billDate = billDate;
        this.amount = amount;
        this.price = price;
    }

    public Customer() {}

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double intoMoney();
    public int getMonth(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(billDate);
        return cal.get(Calendar.MONTH) + 1;
    }

    public int getYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(billDate);
        return cal.get(Calendar.YEAR);
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public void inputCustomer(){
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\t\tEnter customer id: ");
        this.customerId = sc.nextLine();

        System.out.print("\t\tEnter customer name: ");
        this.customerName = sc.nextLine();

        try {
            System.out.print("\t\tEnter bill date (format dd-MM-yyyy): ");
            this.billDate =  sdf.parse(sc.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.print("\t\tEnter amount: ");
        this.amount = sc.nextInt();

        System.out.print("\t\tEnter price: ");
        this.price = sc.nextDouble();
    }

    private String convertDateToString(Date releaseDay) {
        return new SimpleDateFormat("dd/MM/yyyy").format(releaseDay);
    }

    public void showCustomer(){
        System.out.printf("|%15s|%19s|%11s|%8s|%11s", customerId, customerName, convertDateToString(billDate), amount, price);
    }
}

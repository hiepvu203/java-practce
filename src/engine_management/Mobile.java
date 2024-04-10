package engine_management;

import java.util.Scanner;

public class Mobile extends Engine{
    private String country;

    public Mobile(String engineID, String engineName, String manufacturer, int yearMaking, float price, String country) {
        super(engineID, engineName, manufacturer, yearMaking, price);
        this.country = country;
    }

    public Mobile() {}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.println("Enter country: ");
        this.country = sc.nextLine();
    }

    public void display() {
        super.display();
        System.out.println("Country: " + country);
    }
}

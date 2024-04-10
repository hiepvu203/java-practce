package engine_management;

import java.util.Scanner;

public class Engine {
    private String engineID;
    private String engineName;
    private String manufacturer;
    private int yearMaking;
    private float price;

    public Engine(String engineID, String engineName, String manufacturer, int yearMaking, float price) {
        this.engineID = engineID;
        this.engineName = engineName;
        this.manufacturer = manufacturer;
        this.yearMaking = yearMaking;
        this.price = price;
    }

    public Engine() {}

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(int yearMaking) {
        this.yearMaking = yearMaking;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter engine id: ");
        this.engineID = sc.nextLine();

        System.out.println("Enter engine name: ");
        this.engineName = sc.nextLine();

        System.out.println("Enter manufacturer: ");
        this.manufacturer = sc.nextLine();

        System.out.println("Enter year making: ");
        this.yearMaking = sc.nextInt();

        System.out.println("Enter price: ");
        this.price = sc.nextFloat();
    }

    public void display() {
        System.out.println("Engine id: " + engineID);
        System.out.println("Engine name: " + engineName);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Year making: " + yearMaking);
        System.out.println("Price: " + price);
    }
}

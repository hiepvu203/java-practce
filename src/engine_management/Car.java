package engine_management;

import java.util.Scanner;

public class Car  extends Engine{
    private int totalSeat;
    private double speed;

    public Car(String engineID, String engineName, String manufacturer, int yearMaking, float price, int totalSeat, double speed) {
        super(engineID, engineName, manufacturer, yearMaking, price);
        this.totalSeat = totalSeat;
        this.speed = speed;
    }

    public Car() {}

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.println("Enter total seat: ");
        this.totalSeat= sc.nextInt();

        System.out.println("Enter speed: ");
        this.speed= sc.nextDouble();
    }

    public void display() {
        super.display();
        System.out.println("Total seat: " + totalSeat);
        System.out.println("Speed: " + speed);
    }
}

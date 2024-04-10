package engine_management;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Engine> list = new ArrayList<Engine>();
    static void menu() {
        System.out.print("\n\t---- MENU ----");
        System.out.print("\n1. Add information n mobiles"
                + "\n2. Add information n cars"
                + "\n3. Display information both mobile and car"
                + "\n4. Search information by manufacturer name."
                + "\n5. Exit");
    }
    public static void main(String[] args) {
        int selection = 0;
        do{
            menu();
            System.out.println("\nEnter your selection: ");
            selection = Integer.parseInt(sc.nextLine());
            switch (selection){
                case 1: {
                    do{
                        Engine engine = new Mobile();
                        engine.input();
                        list.add(engine);
                        System.out.println("Do you want to continue? (Y/N)");
                    }while(!sc.nextLine().equalsIgnoreCase("n"));
                    break;
                }
                case 2:{
                    do{
                        Engine engine = new Car();
                        engine.input();
                        list.add(engine);
                        System.out.println("Do you want to continue? (Y/N)");
                    }while(!sc.nextLine().equalsIgnoreCase("n"));
                    break;
                }
                case 3:{
                    System.out.println("\n\t\t--- LIST INFORMATION BOTH MOBILE AND CAR ---");
                    for(Engine engine : list){
                        engine.display();
                    }
                    break;
                }
                case 4:{
                    System.out.println("Enter manufacturer name: ");
                    String manufacturerName = sc.nextLine();
                    System.out.println("\n\t\t--- LIST INFORMATION BOTH MOBILE AND CAR FOR " + manufacturerName.toUpperCase() + " ---");
                    for(Engine engine : list){
                        if(engine.getManufacturer().toLowerCase().contains(manufacturerName.toLowerCase())){
                            engine.display();
                        }
                    }
                    break;
                }
                case 5:
                    System.out.println("Thank you used to our program!");
                    break;
                default:
                    System.out.println("Your selection is invalid!");
                    break;
            }
        }while(selection != 5);
    }
}

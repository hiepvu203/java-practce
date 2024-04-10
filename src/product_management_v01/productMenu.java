package product_management_v01;

import java.util.Scanner;

class productMenu {
    static void menu() {
        System.out.println("\t====== MENU ======");
        System.out.print("\n1.Enter information for n");
        System.out.print("\n2.Display the information just entered");
        System.out.print("\n3.Sort information descending by price and display");
        System.out.print("\n4.Exit");

    }
    public static void main(String[] args) {
        int selection = 0;
        product[] products = null;
        product productTemp = new product();

        do {
            menu();
            System.out.print("\nEnter your selection: ");
            Scanner sc = new Scanner(System.in);
            selection = sc.nextInt();
            switch (selection) {
                case 1:
                {
                    int n;
                    while (true) {
                        System.out.print("\nEnter n: ");

                        try {
                            n = sc.nextInt();
                            break; // Exit if successful
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter an integer.");
                        }
                    }
                    products = new product[n];
                    for (int i = 0; i < n; i++) {
                        products[i] = new product();
                        products[i].input();
                    }
                    break;
                }
                case 2:
                {
                    if(products == null)
                        System.out.println("You haven't entered data yet.");
                    else{
                        System.out.println("The data just entered is: ");
                        for(product product : products)
                            product.output();
                    }
                    break;
                }
                case 3:
                {
                    if(products == null)
                        System.out.println("You haven't entered data yet.");
                    else {
                        productTemp.sort(products);
                        System.out.println("The data after sorted: ");
                        for(product product : products)
                            product.output();
                    }
                    break;
                }
                case 4:
                    break;
                default:
                    System.out.println("There are no options for you.");
                    break;
            }
        }while(selection != 4);
    }
}
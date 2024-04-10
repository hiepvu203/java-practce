package product_management_v02;

import java.util.*;

public class testProduct {
    static ArrayList<product> arrlist = new ArrayList<product>();
    public static void highestPricedProduct(){
        double max = 0;
        for(product item : arrlist)
            if((max < item.getPrice()))
                max = item.getPrice();

        System.out.println("Information on item with the highest price");

        for(product item : arrlist)
            if(item.getPrice() == max)
                item.output();
    }

    public static void printItem(){
        for(product item : arrlist)
            item.output();
    }

    public static void findItemName() {
        String name = "milk";
        int count = 0;
        for (product item : arrlist) {
            if (Objects.equals(item.getProductName(), name)) {
                System.out.println(item);
                count++;
            }
        }
        if(count == 0)
            System.out.println("There are no products named 'milk'");
    }

    public static void sortProductDescending() {
        Collections.sort(arrlist, new Comparator<product>() {
            @Override
            public int compare(product o1, product o2) {
                if(o1.getPrice() < o2.getPrice()) {
                    return 1;
                }else if(o1.getPrice() > o2.getPrice()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
    }

    public static void menu() {
        System.out.print("\n\t---- MENU ----");
        System.out.print("\n1. Add product"
                        + "\n2. Find the product with the highest price"
                        + "\n3. Sorted in descending order"
                        + "\n4. Find the item 'milk' in the list"
                        + "\n0. Exit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            menu();
            do {
                System.out.print("\nYour option :");
                while(!sc.hasNextInt()) {
                    System.out.println("Invalid, please try again!");
                    sc.next();
                }
                choice = sc.nextInt();
            }while(choice < 0);
            //sc.nextLine();

            if(choice == 1)
            {
                product p = new product();
                p.input();
                arrlist.add(p);
            }
            else if(choice == 2)
            {
                highestPricedProduct();
            }
            else if(choice == 3)
            {
                sortProductDescending();
                printItem();
            }
            else if(choice == 4)
            {
                findItemName();
            }else if(choice == 0)
            {
                break;
            }
        }while(true);
    }
}

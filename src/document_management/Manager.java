package document_management;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private final ArrayList<Document> docs = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public void inputDocuments(){
        int selection;
        do{
            System.out.print("\n\t1. Book\n\t2. Magazine\n\t3. Newspaper\n\t4. Exit\n");
            System.out.print("Your selection: ");
            selection = sc.nextInt();
            switch(selection){
                case 1 -> {
                    Book bk = new Book();
                    bk.inputBook();
                    docs.add(bk);
                }
                case 2 -> {
                    Magazine mg = new Magazine();
                    mg.inputMagazine();
                    docs.add(mg);
                }
                case 3 -> {
                    Newspaper ns = new Newspaper();
                    ns.inputNewspaper();
                    docs.add(ns);
                }
                case 4 ->{}
                default -> System.out.println("Your selection is invalid!");
            }
        }while(selection != 4);
    }

    public static void bookHeader(){
        System.out.print("\n\n\t\t\t---- Book list ---- \n");
        System.out.print("+---------------+------------------+----------------+-----------------+-------------------+-------+\n");
        System.out.print("|  Document id  |   Manufacturer   | Release number |   Author name   |     Book name     | Pages |\n");
        System.out.print("+---------------+------------------+----------------+-----------------+-------------------+-------+\n");
    }

    public static void magazineHeader(){
        System.out.print("\n\n\t\t\t---- Magazine list ---- \n");
        System.out.print("+---------------+------------------+----------------+--------------+---------------+\n");
        System.out.print("|  Document id  |   Manufacturer   | Release number | Issue number | Release month |\n");
        System.out.print("+---------------+------------------+----------------+--------------+---------------+\n");
    }

    public static void newspaperHeader(){
        System.out.print("\n\n\t\t---- Newspaper list ---- \n");
        System.out.print("+---------------+------------------+----------------+--------------+\n");
        System.out.print("|  Document id  |   Manufacturer   | Release number | Release date |\n");
        System.out.print("+---------------+------------------+----------------+--------------+\n");
    }

    public void showDocuments(){
        boolean bookHeaderPrinted = false;
        boolean magazineHeaderPrinted = false;
        boolean newspaperHeaderPrinted = false;

        for (Document doc : docs) {
            if (doc instanceof Book) {
                if (!bookHeaderPrinted) {
                    bookHeader();
                    bookHeaderPrinted = true;
                }
                ((Book) doc).showBook();
            } else if (doc instanceof Magazine) {
                if (!magazineHeaderPrinted) {
                    magazineHeader();
                    magazineHeaderPrinted = true;
                }
                ((Magazine) doc).showMagazine();
            } else if (doc instanceof Newspaper) {
                if (!newspaperHeaderPrinted) {
                    newspaperHeader();
                    newspaperHeaderPrinted = true;
                }
                ((Newspaper) doc).showNewspaper();
            }
        }
    }

    public void searchByType(){
        int selection;
        do{
            System.out.print("\n\t1. Book\n\t2. Magazine\n\t3. Newspaper\n\t4. Exit\n");
            System.out.print("Your selection: ");
            selection = sc.nextInt();
            switch(selection){
                case 1 -> {
                    for (Document doc : docs)
                        if (doc instanceof Book bk)
                            bk.showBook();
                }
                case 2 -> {
                    for (Document doc : docs)
                        if (doc instanceof Magazine mg)
                            mg.showMagazine();
                }
                case 3 -> {
                    for (Document doc : docs)
                        if (doc instanceof Newspaper ns)
                            ns.showNewspaper();
                }
                case 4 ->{}
                default -> System.out.println("Your selection is invalid!");
            }
        }while(selection != 4);
    }

    public static void menu(){
        System.out.print("""
                \t1. Add information for documents
                \t2. Display information entered documents
                \t3. Search document by type
                \t4. Exit
                """);
    }

    public static void main(String[] args) {
        Manager mg = new Manager();
        int selection;
        do{
            menu();
            System.out.print("Your selection: ");
            selection = sc.nextInt();
            switch(selection){
                case 1 -> mg.inputDocuments();
                case 2 -> mg.showDocuments();
                case 3 -> mg.searchByType();
                case 4 ->{}
                default -> System.out.println("Your selection is invalid!");
            }
        }while(selection != 4);
    }
}

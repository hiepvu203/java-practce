package book_management;

import java.util.Scanner;

public class UnetiBook extends Book{
    private String language;
    private int semester;

    public UnetiBook(String bookName, String bookAuthor, String producer, int yearPublishing, float price, String language, int semester) {
        super(bookName, bookAuthor, producer, yearPublishing, price);
        this.language = language;
        this.semester = semester;
    }

    public UnetiBook(){
        super();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    static Scanner sc = new Scanner(System.in);
    public void input() {
        super.input();

        sc.nextLine();

        System.out.println("Enter language: ");
        this.language = sc.nextLine();

        System.out.println("Enter semester: ");
        this.semester = sc.nextInt();
    }

    public void display() {
        super.display();
        System.out.println("Language: " + language);
        System.out.println("Semester: " + semester);
    }

    public void sort(UnetiBook[] books){
        for(int i = 0; i < books.length - 1; i++){
            for(int j = i + 1; j < books.length; j++){
                if(books[i].getYearPublishing() < books[j].getYearPublishing()){
                    UnetiBook temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }

    public void searchNameBook(UnetiBook[] books){
        System.out.println("Enter book name: ");
        String bookName = sc.nextLine();

        int count = 0;
        for(int i = 0; i< books.length; i++){
            if(books[i].getBookName().equals(bookName)){
                books[i].display();
                count++;
            }
        }
        if(count == 0)
            System.out.println("The book you are looking for is not available.");
    }

    public void searchNameAuthor(UnetiBook[] books){
        System.out.println("Enter book author: ");
        String bookAuthor = sc.nextLine();

        int count = 0;
        for(int i = 0; i< books.length; i++){
            if(books[i].getBookAuthor().equals(bookAuthor)){
                books[i].display();
                count++;
            }
        }
        if(count == 0)
            System.out.println("The author you are looking for is not available.");
    }

    void menu() {
        System.out.print("\n\t---- MENU ----");
        System.out.print("\n1. Add information n books"
                + "\n2. Display information entered"
                + "\n3. Sorted year publishing in descending order"
                + "\n4. Find name book"
                + "\n5. Find name author"
                + "\n6. Exit");
    }

    public static void main(String[] args) {
        int selection;
        UnetiBook book = new UnetiBook();
        UnetiBook[] books = null;

        do{
            book.menu();
            System.out.println("Enter your selection: ");
            selection = sc.nextInt();
            switch (selection){
                case 1: {
                    int n;
                    System.out.println("Enter n: ");
                    n = sc.nextInt();
                    books = new UnetiBook[n];
                    for (int i = 0; i < n; i++) {
                        books[i] = new UnetiBook();
                        books[i].input();
                    }
                    break;
                }
                case 2: {
                    if (books == null)
                        System.out.println("You haven't entered data yet.");
                    else {
                        for (int i = 0; i < books.length; i++)
                            books[i].display();
                    }
                    break;
                }
                case 3: {
                    if (books == null)
                        System.out.println("You haven't entered data yet.");
                    else {
                        book.sort(books);
                        System.out.println("Data after sorted: ");
                        for (int i = 0; i < books.length; i++)
                            books[i].display();
                    }
                    break;
                }
                case 4:{
                    if (books == null)
                        System.out.println("You haven't entered data yet.");
                    else
                        book.searchNameBook(books);
                    break;
                }
                case 5:
                {
                    if (books == null)
                        System.out.println("You haven't entered data yet.");
                    else
                        book.searchNameAuthor(books);
                    break;
                }
                case 6:
                    break;
                default:
                    System.out.println("There are no options for you.");
            }
        }while(selection != 6);
    }
}

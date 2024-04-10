package document_management;

import java.util.Scanner;

public class Book extends Document{
    private String authorName, bookName;
    private int pages;


    public Book() {}

    public String getAuthorName() {
        return authorName;
    }

    public Book(String documentID, String manufacturer, int releaseNumber, String authorName, String bookName, int pages) {
        super(documentID, manufacturer, releaseNumber);
        this.authorName = authorName;
        this.bookName = bookName;
        this.pages = pages;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void inputBook(){
        Scanner sc = new Scanner(System.in);
        super.inputDocument();

        System.out.println("Enter author name: ");
        this.authorName = sc.nextLine();

        System.out.println("Enter book name: ");
        this.bookName = sc.nextLine();

        System.out.println("Enter pages: ");
        this.pages = sc.nextInt();
    }

    public void showBook() {
        super.showDocument();
        System.out.printf("|%17s|%19s|%7s|%n" , this.authorName, this.bookName, this.pages);
        System.out.print("+---------------+------------------+----------------+-----------------+-------------------+-------+\n");
    }
}

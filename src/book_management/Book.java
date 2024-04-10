package book_management;

import java.util.Scanner;

public class Book {
    private String bookName;
    private String bookAuthor;
    private String producer;
    private int yearPublishing;
    private float price;

    public Book(String bookName, String bookAuthor, String producer, int yearPublishing, float price) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.producer = producer;
        this.yearPublishing = yearPublishing;
        this.price = price;
    }

    public Book() {}

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYearPublishing() {
        return yearPublishing;
    }

    public void setYearPublishing(int yearPublishing) {
        this.yearPublishing = yearPublishing;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter book name: ");
        this.bookName = sc.nextLine();

        System.out.println("Enter book author: ");
        this.bookAuthor = sc.nextLine();

        System.out.println("Enter producer: ");
        this.producer = sc.nextLine();

        System.out.println("Enter year publishing: ");
        this.yearPublishing = sc.nextInt();

        System.out.println("Enter price: ");
        this.price = sc.nextFloat();
    }

    public void display() {
        System.out.println("Book name: " + bookName);
        System.out.println("Book author: " + bookAuthor);
        System.out.println("Producer: " + producer);
        System.out.println("Year publishing: " + yearPublishing);
        System.out.println("Price: " + price);
    }
}

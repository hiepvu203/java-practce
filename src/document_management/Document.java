package document_management;

import java.util.Scanner;

public class Document {
    private String documentID, manufacturer;
    private int releaseNumber;

    public Document(String documentID, String manufacturer, int releaseNumber) {
        this.documentID = documentID;
        this.manufacturer = manufacturer;
        this.releaseNumber = releaseNumber;
    }

    public Document() {}

    public String getDocumentID() {return documentID;}
    public void setDocumentID(String documentID) {this.documentID = documentID;}
    public String getManufacturer() {return manufacturer;}
    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}
    public int getReleaseNumber() {return releaseNumber;}
    public void setReleaseNumber(int releaseNumber) {this.releaseNumber = releaseNumber;}

    public void inputDocument() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter document id: ");
        this.documentID = sc.nextLine();

        System.out.println("Enter manufacturer: ");
        this.manufacturer = sc.nextLine();

        System.out.println("Enter release number: ");
        this.releaseNumber = sc.nextInt();
    }

    public void showDocument() {
        System.out.printf("|%15s|%18s|%16s" , this.documentID, this.manufacturer, this.releaseNumber);
    }
}

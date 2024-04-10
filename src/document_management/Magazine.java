package document_management;

import java.util.Scanner;

public class Magazine extends Document{
    private int issueNumber;
    private int releaseMonth;

    public Magazine(String documentID, String manufacturer, int releaseNumber, int issueNumber, int releaseMonth) {
        super(documentID, manufacturer, releaseNumber);
        this.issueNumber = issueNumber;
        this.releaseMonth = releaseMonth;
    }

    public Magazine() {}

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    public void inputMagazine(){
        Scanner sc = new Scanner(System.in);
        super.inputDocument();

        System.out.println("Enter issue number: ");
        this.issueNumber = sc.nextInt();

        System.out.println("Enter release month: ");
        this.releaseMonth = sc.nextInt();
    }

    public void showMagazine(){
        super.showDocument();
        System.out.printf("|%14s|%15s" , this.issueNumber, this.releaseMonth);
        System.out.print("+---------------+------------------+----------------+--------------+---------------+\n");
    }
}

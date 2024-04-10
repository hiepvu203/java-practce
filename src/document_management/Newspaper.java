package document_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Newspaper extends Document{
    private Date releaseDay;

    public Newspaper(String documentID, String manufacturer, int releaseNumber, Date releaseDay) {
        super(documentID, manufacturer, releaseNumber);
        this.releaseDay = releaseDay;
    }

    public Newspaper() {}

    public Date getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(Date releaseDay) {
        this.releaseDay = releaseDay;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public void inputNewspaper() {
        Scanner sc = new Scanner(System.in);
        super.inputDocument();
        try {
            System.out.println("Enter release date (format dd-MM-yyyy): ");
            this.releaseDay = sdf.parse(sc.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertDateToString(Date releaseDay) {
        return new SimpleDateFormat("dd/MM/yyyy").format(releaseDay);
    }

    public void showNewspaper(){
        super.showDocument();
        System.out.printf("|%14s|%n" , convertDateToString(this.releaseDay));
        System.out.print("+---------------+------------------+----------------+--------------+\n");
    }
}

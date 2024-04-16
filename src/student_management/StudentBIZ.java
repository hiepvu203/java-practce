
// Author Vũ Xuân Hiệp

package student_management;

import java.util.Date;
import java.util.Scanner;

public class StudentBIZ extends Student{
    private double scoreMarketing, scoreSales;

    public StudentBIZ(){}

    public StudentBIZ(String id, String name, Date birthday, String major, double scoreMarketing, double scoreSales) {
        super(id, name, birthday, major);
        this.scoreMarketing = scoreMarketing;
        this.scoreSales = scoreSales;
    }

    public double getScoreMarketing() {
        return scoreMarketing;
    }
    public void setScoreMarketing(double scoreMarketing) {
        this.scoreMarketing = scoreMarketing;
    }
    public double getScoreSales() {
        return scoreSales;
    }
    public void setScoreSales(double scoreSales) {
        this.scoreSales = scoreSales;
    }
    @Override
    public double calcAverage() {
        return (2*scoreMarketing + scoreSales)/3;
    }

    public void inputStudent(){
        super.inputStudent();

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap diem marketing: ");
        this.scoreMarketing = sc.nextDouble();

        System.out.println("Nhap diem sales: ");
        this.scoreSales = sc.nextDouble();
    }

    public void displayStudent(){
        super.displayStudent();
        double average = this.calcAverage();
        String rank = this.rank();
        System.out.printf("|%16s|%12s|%9s|%9s|%n", scoreMarketing, scoreSales, average, rank);
        System.out.print("+--------------+---------------+-----------+--------------+----------------+------------+---------+---------+\n");
    }
}

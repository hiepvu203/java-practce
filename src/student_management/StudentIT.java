
// Author Vũ Xuân Hiệp

package student_management;

import java.util.Date;
import java.util.Scanner;

public class StudentIT extends Student{
    private double scoreJava, scoreHtml, scoreCss;

    public StudentIT(){}

    public StudentIT(String id, String name, Date birthday, String major, double scoreJava, double scoreHtml, double scoreCss) {
        super(id, name, birthday, major);
        this.scoreJava = scoreJava;
        this.scoreHtml = scoreHtml;
        this.scoreCss = scoreCss;
    }

    public double getScoreJava() {
        return scoreJava;
    }

    public void setScoreJava(double scoreJava) {
        this.scoreJava = scoreJava;
    }

    public double getScoreHtml() {
        return scoreHtml;
    }

    public void setScoreHtml(double scoreHtml) {
        this.scoreHtml = scoreHtml;
    }

    public double getScoreCss() {
        return scoreCss;
    }

    public void setScoreCss(double scoreCss) {
        this.scoreCss = scoreCss;
    }

    @Override
    public double calcAverage() {
        return (2*scoreJava + scoreHtml + scoreCss)/4;
    }


    public void inputStudent(){
        super.inputStudent();

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap diem java: ");
        this.scoreJava = sc.nextDouble();

        System.out.println("Nhap diem html: ");
        this.scoreHtml = sc.nextDouble();

        System.out.println("Nhap diem css: ");
        this.scoreCss = sc.nextDouble();
    }

    public void displayStudent(){
        super.displayStudent();
        double average = this.calcAverage();
        String rank = this.rank();
        System.out.printf("|%11s|%11s|%10s|%9s|%9s|%n", scoreJava, scoreHtml, scoreCss, average,rank);
        System.out.print("+--------------+---------------+-----------+--------------+-----------+-----------+----------+---------+---------+\n");
    }
}

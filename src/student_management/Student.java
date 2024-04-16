// Author Vũ Xuân Hiệp
package student_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class Student {
    private String id, name;
    private Date birthday;
    private String major;

    // Set to store unique student IDs
    private static final Set<String> store = new HashSet<>();

    public Student(){}

    public Student(String id, String name, Date birthday, String major) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public abstract double calcAverage();

    public String rank(){
        double point = this.calcAverage();
        if(point < 5)
            return "Yeu";
        else if(point >= 5 && point < 7)
            return "Trung binh";
        else if(point >=7 && point < 8)
            return "Kha";
        else if(point >= 8)
            return "Gioi";
        return null;
    }

    public void inputStudent(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Nhap ma sinh vien: ");
            String newId = sc.nextLine();

            // Check if the ID is already in use
            if (store.contains(newId)) {
                System.out.println("Ma sinh vien da ton tai. Vui long nhap lai.");
            } else {
                this.id = newId;
                store.add(newId);
                break;
            }
        }

        System.out.println("Nhap ten sinh vien: ");
        this.name = sc.nextLine();

        boolean validDate = false;
        while(!validDate){
            System.out.print("\t\tNhap ngay sinh (theo dang dd-MM-yyyy): ");
            String inputDate = sc.nextLine();

            try {
                this.birthday = sdf.parse(inputDate);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("\tNgay sinh nhap khong dung dinh dang. Vui long nhap lai.");
            }
        }

        System.out.println("Nhap chuyen nganh: ");
        this.major = sc.nextLine();
    }

    private String convertDateToString(Date releaseDay) {
        return new SimpleDateFormat("dd/MM/yyyy").format(releaseDay);
    }

    public void displayStudent(){
        System.out.printf("|%14s|%15s|%11s|%14s", id, name, convertDateToString(birthday), major);
    }
}
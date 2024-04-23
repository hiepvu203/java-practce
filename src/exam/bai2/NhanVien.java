package exam.bai2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class NhanVien {
    private String id, name, gender;
    private Date birthday;
    private String address;
    private double salary;

    public NhanVien() {}

    // Set to store unique student IDs
    private static final Set<String> store = new HashSet<>();

    public NhanVien(String id, String name, String gender, Date birthday, String address, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.salary = salary;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public void nhapNhanVien() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Nhap ma nhan vien: ");
            String newId = sc.nextLine();

            // Check if the ID is already in use
            if (store.contains(newId)) {
                System.out.println("Ma nhan vien da ton tai. Vui long nhap lai.");
            } else {
                this.id = newId;
                store.add(newId);
                break;
            }
        }

        System.out.println("Nhap hp va ten nhan vien: ");
        this.name = sc.nextLine();

        System.out.println("Nhap gioi tinh: ");
        this.gender = sc.nextLine();

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

        System.out.println("Nhap que quan: ");
        this.address = sc.nextLine();
    }

    private String convertDateToString(Date releaseDay) {
        return new SimpleDateFormat("dd/MM/yyyy").format(releaseDay);
    }

    public void hienThiNhanVien() {
        System.out.printf("|%14s|%15s|%11s|%11s|%14s", id, name, convertDateToString(birthday),gender, address);
    }

    public abstract double calcSalary();

    public int calcAge (int retireYear){
        Calendar ca = new GregorianCalendar();
        ca.setTime(this.birthday);

        Calendar reYearCale = new GregorianCalendar(retireYear, Calendar.JANUARY, 1);
        int age = reYearCale.get(Calendar.YEAR) - ca.get(Calendar.YEAR);
        if(ca.get(Calendar.MONTH) > reYearCale.get(Calendar.MONTH) ||
                (ca.get(Calendar.MONTH) == reYearCale.get(Calendar.MONTH) &&
                        ca.get(Calendar.DAY_OF_MONTH) > reYearCale.get(Calendar.DAY_OF_MONTH))){
            age--;
        }
        return age;
    }


}

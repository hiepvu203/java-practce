package exam.bai2;

import java.util.Date;
import java.util.Scanner;

public class NhanVienChinhThuc extends NhanVien{
    private double hsl;
    private long salaryBasic;
    private String role;

    public NhanVienChinhThuc(){
        super();
    }

    public NhanVienChinhThuc(String id, String name, String gender, Date birthday, String address, double salary, double hsl, long salaryBasic, String role) {
        super(id, name, gender, birthday, address, salary);
        this.hsl = hsl;
        this.salaryBasic = salaryBasic;
        this.role = role;
    }

    public double getHsl() {
        return hsl;
    }

    public void setHsl(double hsl) {
        this.hsl = hsl;
    }

    public long getSalaryBasic() {
        return salaryBasic;
    }

    public void setSalaryBasic(long salaryBasic) {
        this.salaryBasic = salaryBasic;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void nhapNhanVien() {
        super.nhapNhanVien();
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap he so luong: ");
        this.hsl = sc.nextDouble();

        System.out.println("Nhap luong co ban: ");
        this.salaryBasic = sc.nextLong();
        sc.nextLine();

        System.out.println("Nhap chuc vu: ");
        this.role = sc.nextLine();
    }

    public void hienThiNhanVienChinhThuc() {
        super.hienThiNhanVien();
        double thucLinh = Math.round(this.calcSalary());
        System.out.printf("|%13s|%14s|%11s|%17s|%n", hsl, salaryBasic, role, thucLinh);
        System.out.print("+--------------+---------------+-----------+-----------+--------------+-------------+--------------+-----------+-----------------+\n");
    }

    public double phuCap() {
        if(this.role.equals("Giam doc"))
            return 0.6;
        if(this.role.equals("Truong phong"))
            return 0.6;
        if(this.role.equals("Nhan vien"))
            return 0.6;
        return 0;
    }

    @Override
    public double calcSalary() {
        return (this.hsl + this.phuCap()) * this.salaryBasic;
    }
}

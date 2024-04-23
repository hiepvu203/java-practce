package exam.bai2;

import java.util.Date;
import java.util.Scanner;

public class NhanVienThoiVu extends NhanVien{
    private int soNgayCong;
    private double donGia;

    public NhanVienThoiVu(){
        super();
    }

    public NhanVienThoiVu(String id, String name, String gender, Date birthday, String address, double salary, int soNgayCong, double donGia) {
        super(id, name, gender, birthday, address, salary);
        this.soNgayCong = soNgayCong;
        this.donGia = donGia;
    }

    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void nhapNhanVien() {
        super.nhapNhanVien();
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so ngay cong: ");
        this.soNgayCong = sc.nextInt();

        System.out.println("Nhap don gia: ");
        this.donGia = sc.nextDouble();
    }

    @Override
    public double calcSalary() {
        return donGia * soNgayCong;
    }

    public void hienThiNhanVienThoiVu() {
        super.hienThiNhanVien();
        double thucLinh = Math.round(this.calcSalary());
        System.out.printf("|%14s|%11s|%17s|%n", soNgayCong, donGia, thucLinh);
        System.out.print("+--------------+---------------+-----------+-----------+--------------+--------------+-----------+-----------------+\n");
    }
}

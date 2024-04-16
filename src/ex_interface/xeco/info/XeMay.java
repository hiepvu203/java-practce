package ex_interface.xeco.info;

import java.util.Scanner;

public class XeMay implements IXe{
    String bienSo, loaiXe, mauXe;
    double giaTien;

    public XeMay(String bienSo, String loaiXe, String mauXe, double giaTien) {
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.mauXe = mauXe;
        this.giaTien = giaTien;
    }

    public XeMay() {}

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập biển số: ");
        this.bienSo = sc.nextLine();

        System.out.println("Nhập loại xe: ");
        this.loaiXe = sc.nextLine();

        System.out.println("Nhập màu xe: ");
        this.mauXe = sc.nextLine();

        System.out.println("Nhập giá tiền: ");
        this.giaTien = sc.nextDouble();
    }

    public void display() {
        System.out.println("Biển số: " + bienSo + ", Loại xe: " + loaiXe + ", Màu xe: " + mauXe + ", Giá tiền: " + giaTien);
    }
}

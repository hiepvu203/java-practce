package ex_interface.hoabinh.xemay;

import ex_interface.xeco.info.XeMay;

import java.util.Scanner;

public class XeMayHoaBinh extends XeMay {
    private int n;
    XeMay[] arrayXe;

    public XeMayHoaBinh(String bienSo, String loaiXe, String mauXe, double giaTien, int n, XeMay[] arrayXe) {
        super(bienSo, loaiXe, mauXe, giaTien);
        this.n = n;
        this.arrayXe = arrayXe;
    }

    public XeMayHoaBinh(){
        super();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public XeMay[] getArrayXe() {
        return arrayXe;
    }

    public void setArrayXe(XeMay[] arrayXe) {
        this.arrayXe = arrayXe;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so luong xe may hoa binh: ");
        this.n = sc.nextInt();

        arrayXe = new XeMay[n];
        for(int i = 0 ; i< n; i++) {
            System.out.println("Nhap thong tin xe may thu " + (i + 1));
            arrayXe[i] = new XeMay();
            arrayXe[i].input();
        }
    }

    public void display() {
        for(var i : arrayXe)
            i.display();
    }
}

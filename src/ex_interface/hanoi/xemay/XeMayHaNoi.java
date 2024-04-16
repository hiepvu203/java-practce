package ex_interface.hanoi.xemay;

import ex_interface.xeco.info.XeMay;

import java.util.Scanner;

public class XeMayHaNoi extends XeMay {
    private int n;
    XeMay[] arrayXe;

    public XeMayHaNoi(String bienSo, String loaiXe, String mauXe, double giaTien, int n, XeMay[] arrayXe) {
        super(bienSo, loaiXe, mauXe, giaTien);
        this.n = n;
        this.arrayXe = arrayXe;
    }

    public XeMayHaNoi(){
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

        System.out.println("Nhap so luong xe may ha noi: ");
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

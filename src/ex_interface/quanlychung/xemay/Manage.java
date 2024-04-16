package ex_interface.quanlychung.xemay;

import ex_interface.hanoi.xemay.XeMayHaNoi;
import ex_interface.xeco.info.XeMay;

import java.util.Scanner;

public class Manage {

    public static int soThuTu(String bienSo) {
        XeMay xm = new XeMay();

        String[] parts = bienSo.split("-");
        return Integer.parseInt(parts[1].replaceAll("\\.", ""));
    }

    public static void main(String[] args) {
        XeMayHaNoi xhn = new XeMayHaNoi();

        xhn.input();

        xhn.display();
    }
}

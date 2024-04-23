package exam.bai2;

import java.util.*;

public class Manager {
    private final ArrayList<NhanVien> staffs = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public void nhapNhanVien(){
        int selection;
        do{
            System.out.print("\n\t1. Nhan vien chinh thuc\n\t2. Nhan vien thoi vu\n\t3. Exit\n");
            System.out.print("Lua chon cua ban: ");
            selection = sc.nextInt();
            switch(selection){
                case 1 -> {
                    NhanVienChinhThuc ct = new NhanVienChinhThuc();
                    ct.nhapNhanVien();
                    staffs.add(ct);
                }
                case 2 -> {
                    NhanVienThoiVu tv = new NhanVienThoiVu();
                    tv.nhapNhanVien();
                    staffs.add(tv);
                }
                case 3 -> {}
                default -> System.out.println("Lua chon cua ban khong phu hop!");
            }
        }while(selection != 3);
    }

    public static void NhanVienCTHeader(){
        System.out.print("\n\n\t\t\t----  Danh sach nhan vien chinh thuc ---- \n");
        System.out.print("+--------------+---------------+-----------+-----------+--------------+-------------+--------------+-----------+-----------------+\n");
        System.out.print("| Ma nhan vien |   Ho va ten   | Ngay sinh | Gioi tinh |   Que quan   | He so luong | Luong co ban |  Chuc vu  | Luong thuc linh |\n");
        System.out.print("+--------------+---------------+-----------+-----------+--------------+-------------+--------------+-----------+-----------------+\n");
    }

    public static void NhanVienTVHeader(){
        System.out.print("\n\n\t\t\t---- Danh sach nhan vien thoi vu ---- \n");
        System.out.print("+--------------+---------------+-----------+-----------+--------------+--------------+-----------+-----------------+\n");
        System.out.print("| Ma nhan vien |   Ho va ten   | Ngay sinh | Gioi tinh |   Que quan   | So ngay cong |  Don gia  | Luong thuc linh |\n");
        System.out.print("+--------------+---------------+-----------+-----------+--------------+--------------+-----------+-----------------+\n");
    }

    public void hienThiNhanVien(){
        boolean NVCTHeaderPrinted = false;
        boolean NVTVHeaderPrinted = false;

        for (NhanVien nv : staffs) {
            if (nv instanceof NhanVienChinhThuc) {
                if (!NVCTHeaderPrinted) {
                    NhanVienCTHeader();
                    NVCTHeaderPrinted = true;
                }
                ((NhanVienChinhThuc) nv).hienThiNhanVienChinhThuc();
            } else if (nv instanceof NhanVienThoiVu) {
                if (!NVTVHeaderPrinted) {
                    NhanVienTVHeader();
                    NVTVHeaderPrinted = true;
                }
                ((NhanVienThoiVu) nv).hienThiNhanVienThoiVu();
            }
        }
    }

    public void caclAvg() {
        double sumLuongNVCT = 0;
        double sumLuongNVTV = 0;
        int count1 = 0, count2 = 0;

        for (NhanVien nv : staffs) {
            if (nv instanceof NhanVienChinhThuc) {
                sumLuongNVCT += nv.calcSalary();
                count1++;
            } else if (nv instanceof NhanVienThoiVu) {
                sumLuongNVTV += nv.calcSalary();
                count2++;
            }
        }

        double AVG1 = sumLuongNVCT /count1;
        double AVG2 = sumLuongNVTV /count2;
        System.out.println("Trung binh luong cua nhan vien chinh thuc: " + Math.round(AVG1));
        System.out.println("Trung binh luong cua nhan vien thoi vu: " + Math.round(AVG2));
    }

    public void BiggestSalary() {
        NhanVien staffHightestSalary = staffs.get(0);
        System.out.println("\t\t --- Nhan vien co luong cao nhat ------\n");
        for (NhanVien nv : staffs)
            if (nv.calcSalary() > staffHightestSalary.calcSalary())
                staffHightestSalary = nv;
        staffHightestSalary.hienThiNhanVien();
    }

    public void sortTD() {
        int n = staffs.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (staffs.get(j).calcSalary() > staffs.get(j + 1).calcSalary()) {
                    // Hoán đổi vị trí nếu lương của nhân viên j lớn hơn nhân viên j+1
                    NhanVien temp = staffs.get(j);
                    staffs.set(j, staffs.get(j + 1));
                    staffs.set(j + 1, temp);
                }
            }
        }

        boolean NVCTHeaderPrinted = false;
        boolean NVTVHeaderPrinted = false;

        for (NhanVien nv : staffs) {
            if (nv instanceof NhanVienChinhThuc) {
                if (!NVCTHeaderPrinted) {
                    NhanVienCTHeader();
                    NVCTHeaderPrinted = true;
                }
                ((NhanVienChinhThuc) nv).hienThiNhanVienChinhThuc();
            } else if (nv instanceof NhanVienThoiVu) {
                if (!NVTVHeaderPrinted) {
                    NhanVienTVHeader();
                    NVTVHeaderPrinted = true;
                }
                ((NhanVienThoiVu) nv).hienThiNhanVienThoiVu();
            }
        }
    }

    public void caclYearRetire(int specificYear){
        for(NhanVien nv : staffs){
            int age = nv.calcAge(specificYear);
            if((age == 60 && nv.getGender().equalsIgnoreCase("nam")) || (age == 55 && nv.getGender().equalsIgnoreCase("nu"))){
                nv.hienThiNhanVien();
            }
        }
    }

    public void remove(){
        sc.nextLine();
        System.out.println("Nhap ma nhan vien can tim: ");
        String id = sc.nextLine();

        NhanVien nvCanXoa = null;
        for(NhanVien nv : staffs){
            if(nv.getId().equals(id)){
                nvCanXoa = nv;
                break;
            }
        }
        if(nvCanXoa != null){
            staffs.remove(nvCanXoa);
            System.out.println("Nhan vien co ma" + id + " da duoc xoa thanh cong!");
        }else {
            System.out.println("Khong tim thay thong tin nhan vien co ma " + id);
        }
    }

    public static void menu(){
        System.out.print("""
                \t\t1. Nhap danh sach nhan vien
                \t\t2. Xuat danh sach nhan vien.
                \t\t3. Xuat ra trung binh luong cho tung loai nhan vien
                \t\t4. Xuat ra nhan vien co luong cao nhat.
                \t\t5. Sap xep danh sach nhan vien theo chieu tang dan cua luong.
                \t\t6. Xuat ra danh sach nhan vien se nghi huu trong nam 2024 (nam : 60, nu : 55).
                \t\t7. Xoa nhan vien theo ma nhan vien duoc nhap vao tu ban phim
                \t\t8. Thoat chuong trinh.
                """);
    }

    public static void main(String[] args) {
        Manager mg = new Manager();
        int selection;
        do{
            menu();
            System.out.print("Lua chon cua ban: ");
            selection = sc.nextInt();
            switch(selection){
                case 1 -> mg.nhapNhanVien();
                case 2 -> mg.hienThiNhanVien();
                case 3 -> mg.caclAvg();
                case 4 -> mg.BiggestSalary();
                case 5 -> mg.sortTD();
                case 6 -> mg.caclYearRetire(2024);
                case 7 -> mg.remove();
                case 8 ->{}
                default -> System.out.println("Lua chon cua ban khong dung!");
            }
        }while(selection != 8);
    }
}

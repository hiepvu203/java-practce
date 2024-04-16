// Author Vũ Xuân Hiệp

package student_management;

import java.util.*;

public class Manage{
    private final ArrayList<Student> students = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public void inputStudents(){
        int selection;
        do{
            System.out.print("\n\t1. Sinh vien IT\n\t2. Sinh vien Biz\n\t3. Exit\n");
            System.out.print("Lua chon cua ban: ");
            selection = sc.nextInt();
            switch(selection){
                case 1 -> {
                    StudentIT it = new StudentIT();
                    it.inputStudent();
                    students.add(it);
                }
                case 2 -> {
                    StudentBIZ biz = new StudentBIZ();
                    biz.inputStudent();
                    students.add(biz);
                }
                case 3 -> {}
                default -> System.out.println("Lua chon cua ban khong phu hop!");
            }
        }while(selection != 3);
    }

    public static void StudentITHeader(){
        System.out.print("\n\n\t\t\t----  Danh sach sinh vien IT ---- \n");
        System.out.print("+--------------+---------------+-----------+--------------+-----------+-----------+----------+---------+---------+\n");
        System.out.print("| Ma sinh vien |   Ho va ten   | Ngay sinh | Chuyen nganh | Diem Java | Diem HTML | Diem CSS | Diem TB | Hoc luc |\n");
        System.out.print("+--------------+---------------+-----------+--------------+-----------+-----------+----------+---------+---------+\n");
    }

    public static void StudentBizHeader(){
        System.out.print("\n\n\t\t\t---- Danh sach sinh vien Biz ---- \n");
        System.out.print("+--------------+---------------+-----------+--------------+----------------+------------+---------+---------+\n");
        System.out.print("| Ma sinh vien |   Ho va ten   | Ngay sinh | Chuyen nganh | Diem marketing | Diem sales | Diem TB | Hoc luc |\n");
        System.out.print("+--------------+---------------+-----------+--------------+----------------+------------+---------+---------+\n");
    }

    public void showStudents(){
        boolean StudentITHeaderPrinted = false;
        boolean StudentBizHeaderPrinted = false;

        for (Student student : students) {
            if (student instanceof StudentIT) {
                if (!StudentITHeaderPrinted) {
                    StudentITHeader();
                    StudentITHeaderPrinted = true;
                }
                student.displayStudent();
            } else if (student instanceof StudentBIZ) {
                if (!StudentBizHeaderPrinted) {
                    StudentBizHeader();
                    StudentBizHeaderPrinted = true;
                }
                student.displayStudent();
            }
        }
    }

    public void checkRank(){
        boolean StudentITHeaderPrinted = false;
        boolean StudentBizHeaderPrinted = false;

        int count = 0;
        for (Student student : students) {
            if(student.rank().equals("Gioi")){
                if (student instanceof StudentIT) {
                    if (!StudentITHeaderPrinted) {
                        StudentITHeader();
                        StudentITHeaderPrinted = true;
                    }
                    student.displayStudent();
                } else if (student instanceof StudentBIZ) {
                    if (!StudentBizHeaderPrinted) {
                        StudentBizHeader();
                        StudentBizHeaderPrinted = true;
                    }
                    student.displayStudent();
                }
                count++;
            }
        }
        if(count == 0)
            System.out.println("Khong co sinh vien co hoc luc gioi!");
    }

    public void sortGD(){
        students.sort((o1, o2) -> Double.compare(o2.calcAverage(), o1.calcAverage()));
        for (Student student : students)
            student.displayStudent();
    }

    public void searchByID(){
        int count = 0;
        sc.nextLine();
        System.out.println("Nhap id muon tim: ");
        String id = sc.nextLine();

        for (Student student : students) {
            if (Objects.equals(student.getId(), id)) {
                if (student instanceof StudentIT) {
                    StudentITHeader();
                    student.displayStudent();
                } else if (student instanceof StudentBIZ) {
                    StudentBizHeader();
                    student.displayStudent();
                }
                count++;
            }
        }
        if(count == 0)
            System.out.println("Khong co sinh vien theo ma can tim!");
    }

    public void listRank(){
        boolean StudentITHeaderPrinted = false;
        int count = 0;

        for (Student student : students)
            if (student instanceof StudentIT)
                if (student.rank().equals("Yeu"))
                    count++;

        if(count == 0)
            System.out.println("Khong co sinh vien IT co hoc luc yeu!");
        else{
            for (Student student : students) {
                if (student instanceof StudentIT) {
                    if (!StudentITHeaderPrinted) {
                        StudentITHeader();
                        StudentITHeaderPrinted = true;
                    }
                    if (student.rank().equals("Yeu"))
                        student.displayStudent();
                }
            }
        }
    }

    public static void menu(){
        System.out.print("""
                \t\t1. Nhap danh sach sinh vien
                \t\t2. Xuat danh sach sinh vien.
                \t\t3. Xuat danh sach sinh vien co hoc luc gioi.
                \t\t4. Sap xep danh sach sinh vien giam dan theo diem trung binh.
                \t\t5. Tim kiem thong tin theo ma sinh vien.
                \t\t6. Dua ra thong tin sinh vien IT co hoc luc yeu.
                \t\t7. Thoat chuong trinh
                """);
    }

    public static void main(String[] args) {
        Manage mg = new Manage();
        int selection;
        do{
            menu();
            System.out.print("Lua chon cua ban: ");
            selection = sc.nextInt();
            switch(selection){
                case 1 -> mg.inputStudents();
                case 2 -> mg.showStudents();
                case 3 -> mg.checkRank();
                case 4 -> mg.sortGD();
                case 5 -> mg.searchByID();
                case 6 -> mg.listRank();
                case 7 ->{}
                default -> System.out.println("Lua chon cua ban khong dung!");
            }
        }while(selection != 7);
    }
}
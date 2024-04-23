package exam.bai1;

import java.util.Scanner;

public class Main {
    public static boolean checkSoNguyenTo (int number) {
        if (number <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
                return false;
        return true;
    }

    public static int findMin(int[][] a){
        int minElement = a [0][0];
        for (int[] row : a)
            for (int element : row)
                if (element < minElement)
                    minElement = element;
        return minElement;
    }

    public static int findMax(int [][] a){
        int maxElement = a [0][0];
        for (int[] row : a)
            for (int element : row)
                if (element > maxElement)
                    maxElement = element;
        return maxElement;
    }

    public static void main(String[] args) {
        System.out.println("Nhap n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] a = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print("Nhập phần tử thứ [" + i + ", " + j + "]: ");
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Ma tran vừa nhập: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.print("\n");
        }

        System.out.println("Cac so nguyen to cua ma tran");
        for(int i = 0 ; i< n; i++)
            for(int j = 0 ; j < n; j++)
                if(checkSoNguyenTo(a[i][j]))
                    System.out.println(a[i][j] + "\n");

        int min = findMin(a);
        int max = findMax(a);

        System.out.println("So lon nhat ma tran la: " + max);
        System.out.println("So nho nhat ma tran la: " + min);
    }
}

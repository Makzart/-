import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Lab2 obj = new Lab2();
        obj.Tree();
        obj.Array();
    }

    public void Tree() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введiть кiлькiсть рiвнiв ялинки: ");
        int levels = in.nextInt();
        in.close();
        System.out.print("Ялинка:\n");
        for (int i = 0; i < levels; i++) {
              for (int j = 0; j < levels - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 1 + 1; j++) {
                System.out.print("*");
                System.out.print(" ");
            }

            System.out.println(); 
        }
    }

    

    public void Array() {
        int rows = 4; 
        int cols = 4; 
        int[][] array = new int[rows][cols];
        int a = 3; 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = a;
                a += 3;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

}

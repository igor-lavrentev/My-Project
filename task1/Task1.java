import java.util.Arrays;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {

        System.out.println("n :");
        int n = new Scanner(System.in).nextInt();

        System.out.println("m :");
        int m = new Scanner(System.in).nextInt();

        array(n, m);
    }

    public static void array( int n, int m) {
        int[] arr = new int[n];
        Arrays.setAll(arr, i -> ++i);

        int current = 1;
        System.out.print("Path: ");

        do {
            System.out.print(current);
            current = (current + m - 2) % n + 1;
        } while (current != 1);
    }
}
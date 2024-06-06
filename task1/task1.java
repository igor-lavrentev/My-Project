import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer n = Integer.valueOf((args[0]));
        Integer m = Integer.valueOf((args[1]));

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
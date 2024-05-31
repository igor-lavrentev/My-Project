
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String pathCircle = scan.nextLine();
        String pathDots = scan.nextLine();

        List<Double> circle = new ArrayList<>();


        try {
            File file = new File(pathCircle);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                circle.add(scanner.nextDouble());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
        }

        try {
            File file = new File(pathDots);
            Scanner scanner = new Scanner(file);

            double x;
            double y;

            while (scanner.hasNextInt()) {
                x = scanner.nextDouble();
                y = scanner.nextDouble();
                cricle(x, y, circle);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
        }

    }

    private static void cricle(double x, double y, List<Double> nums) {

        double value = Math.pow(x - nums.get(0), 2) + Math.pow(y - nums.get(1), 2) - Math.pow(nums.get(2), 2);
        if (value == 0) {
            System.out.println(0);
        } else if (value < 0) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
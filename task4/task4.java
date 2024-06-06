import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Task4 {
    public static void main(String[] args) {


        File file = new File(args[0]);

        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String addNum;
            while ((addNum = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(addNum.trim()));
            }
        } catch (IOException e) {
            System.out.println(e);
            return;
        }

        Collections.sort(numbers);
        int median = numbers.size() / 2;
        int result = 0;
        for (int n : numbers) {
            result += Math.abs(n - numbers.get(median));
        }
        System.out.println(result);
    }
}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long count = 0;

        count = n * (n - 1) * (n - 2) / 6;


        System.out.println(count + " 3");
    }
}

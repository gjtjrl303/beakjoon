
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num1 = 1;
        long num2 = 2L;
        long num3 = 3L;
        int N = scanner.nextInt();

        if (N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 3; i <= N; i++) {
            num3 = (num1 + num2) % 10;
            num1 = num2;
            num2 = num3;
        }

        System.out.println(num2 % 10);
    }
}

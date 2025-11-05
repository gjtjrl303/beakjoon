
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n, m;

        n = scanner.nextInt();
        m = scanner.nextInt();

        if (n % 3 == 0) {
            System.out.println("YES");
        } else if (m % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

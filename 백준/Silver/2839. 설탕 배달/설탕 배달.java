
import java.util.Scanner;

public class Main {

    static int[] kg = {5, 3};
    static int N;
    static int count = 0;
    static boolean find = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();


        if (N < 3) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i <2; i++) {
            int sum = kg[i];
            count++;
            recursion(sum);
            count--;
        }

        if (!find) {
            System.out.println(-1);
            return;
        }
    }

    private static void recursion(int sum) {
        if (sum == N && !find) {
            System.out.println(count);
            find = true;
            return;
        }

        if (sum > N) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            int newSum = sum + kg[i];
            count++;
            recursion(newSum);
            if (find) {
                return;
            }
            count--;
        }
        }
}

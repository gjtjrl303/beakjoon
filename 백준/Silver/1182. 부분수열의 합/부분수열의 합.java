
import java.util.Scanner;

public class Main {

    public static int N;
    public static int S;
    public static int count = 0;
    public static int[] numbers;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        S = scanner.nextInt();
        numbers = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            int sum = numbers[i];
            dfs(sum, i);
        }

        System.out.println(count);
    }

    public static void dfs(int sum, int start) {
        if (sum == S) {
            count++;
        }
//        System.out.println(sum);

        for (int i = start + 1; i <= N; i++) {
            sum += numbers[i];
            dfs(sum, i);
            sum -= numbers[i];
        }
    }
}

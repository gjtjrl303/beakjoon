
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        long[] dp1 = new long[N + 3];
        long[] dp2 = new long[N + 3];

        dp1[1] = 1;
        dp1[2] = 1;
        dp1[3] = 1;
        dp2[1] = 0;
        dp2[2] = 0;
        dp2[3] = 1;

        for (int i = 4; i <= N; i++) {
            dp1[i] = (dp1[i - 1] + dp1[i - 3])%1_000_000_009;
            dp2[i] = (dp2[i - 1] + dp2[i - 3])%1_000_000_009;
        }

        System.out.println((dp1[N] + dp2[N])%1_000_000_009);
    }
}

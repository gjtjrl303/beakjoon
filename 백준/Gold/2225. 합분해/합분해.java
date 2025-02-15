import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int mod = 1000000000;
        long[][] dp = new long[201][201];

        for (int i = 0; i <=200; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= mod;
                }
            }
        }

        System.out.println(dp[K][N] % mod);

    }
}

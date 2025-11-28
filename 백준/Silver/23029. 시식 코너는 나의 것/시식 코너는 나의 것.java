
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N+1];
        int[][] dp  = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            array[i] = scanner.nextInt();
        }

        dp[0][0] =0;
        dp[0][1] =0;
        dp[0][2] =0;

        dp[1][0] = array[1];
        dp[1][1] = 0;
        dp[1][2] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 2][0] + array[i], dp[i-1][2] + array[i]);
            dp[i][1] = dp[i - 1][0] + array[i] / 2;
            dp[i][2] = Math.max(dp[i - 1][1],dp[i-1][2]);
        }

        int max = Math.max(dp[N][0], dp[N][1]);
        max = Math.max(max, dp[N][2]);

//        for (int i = 0; i <= N; i++) {
//            System.out.println(dp[i][0] + " " + dp[i][1] + " " + dp[i][2]);
//        }
        System.out.println(max);
    }
}

import java.util.Scanner;

public class Main {

    static final int FIRST = 0;
    static final int SECOND = 1;
    static final int NONE = 2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n + 1];
        int[][] dp = new int[n+1][3];

        for (int i = 1; i < n + 1; i++) {
            nums[i] = scanner.nextInt();
        }

        dp[1][FIRST] = nums[1];
        dp[1][SECOND] = 0;
        dp[1][NONE] = 0;

        for (int i = 2; i < n + 1; i++) {
            dp[i][FIRST] = dp[i - 1][NONE] + nums[i];
            dp[i][SECOND] = dp[i - 1][FIRST] + nums[i];
            dp[i][NONE] = Math.max(Math.max(dp[i - 1][FIRST], dp[i - 1][SECOND]), dp[i - 1][NONE]);
        }

        System.out.println(Math.max(Math.max(dp[n][FIRST], dp[n][SECOND]), dp[n][NONE]));
    }

}

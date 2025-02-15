import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX = 1001;
    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] colors = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];
        int sum=0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][RED] = colors[1][0];
        dp[1][GREEN] = colors[1][1];
        dp[1][BLUE] = colors[1][2];

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == RED) {
                    dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]) + colors[i][0];
                } else if (j == GREEN) {
                    dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2])+ colors[i][1];
                } else if (j == BLUE) {
                    dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1])+ colors[i][2];
                }
            }
        }

        System.out.println(Math.min(dp[N][2], Math.min(dp[N][0], dp[N][1])));
    }
}

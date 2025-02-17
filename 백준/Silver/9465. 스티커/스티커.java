import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i <T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] num = new int[2][n + 1];
            int[][] dp = new int[3][n + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    num[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = 0;
            dp[1][1] = num[0][0];
            dp[2][1] = num[1][0];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(Math.max(dp[0][j-1], dp[1][j-1]), dp[2][j-1]);
                dp[1][j] = Math.max(dp[0][j-1], dp[2][j-1]) + num[0][j-1];
                dp[2][j] = Math.max(dp[0][j-1], dp[1][j-1]) + num[1][j-1];
            }

            System.out.println(Math.max(Math.max(dp[0][n], dp[1][n]), dp[2][n]));
        }





    }
}

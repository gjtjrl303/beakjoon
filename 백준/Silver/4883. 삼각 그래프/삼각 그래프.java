
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int[][] array = new int[N + 1][3];
            int[][] dp = new int[N + 1][3];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[1][1] = array[1][1];
            dp[1][2] = array[1][1] + array[1][2];
            dp[2][0] = array[1][1] + array[2][0];
            int min = Math.min(dp[1][1], dp[1][2]);
            dp[2][1] = Math.min(dp[2][0],min) + array[2][1];
            min = Math.min(dp[1][1], dp[1][2]);
            dp[2][2] = Math.min(min, dp[2][1]) + array[2][2];

            for (int i = 3; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + array[i][0];

                min = Math.min(dp[i - 1][0], dp[i - 1][1]);
                min = Math.min(dp[i - 1][2], min);
                dp[i][1] = Math.min(min, dp[i][0]) + array[i][1];

                min = Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][2] = Math.min(min, dp[i][1]) + array[i][2];
            }

//            for (int i = 1; i <= N; i++) {
//                bw.write(dp[i][0] + " " + dp[i][1] + " " + dp[i][2] + "\n");
//            }
            bw.write(count + ". " + dp[N][1] + "\n");
            bw.flush();
            count++;
        }
    }
}

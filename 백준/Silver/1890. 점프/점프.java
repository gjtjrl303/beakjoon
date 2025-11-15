
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
        long[][] numbers;
        long[][] dp;

        int N = Integer.parseInt(br.readLine());
        numbers = new long[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                numbers[i][j] = Long.parseLong(st.nextToken());
            }
        }
        dp[0][0] = 1L;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) break;

                if (dp[i][j] != 0) {
                    if (numbers[i][j] + i < N) {
                        dp[(int) (numbers[i][j] + i)][j]+=dp[i][j];
                    }

                    if (numbers[i][j] + j < N) {
                        dp[i][(int) (numbers[i][j] + j)]+=dp[i][j];
                    }
                }
            }
        }

        bw.write(dp[N - 1][N - 1]+ "");
        bw.flush();
    }
}

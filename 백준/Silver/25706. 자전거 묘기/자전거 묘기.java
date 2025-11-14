
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

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[N] = 1;
        for (int i = N - 1; i >= 1; i--) {
            if (num[i] == 0) {
                dp[i] = dp[i + 1] + 1;
            } else {
                if (i + num[i] + 1 <= N) {
                    dp[i] = dp[i + num[i] + 1] + 1;
                } else {
                    dp[i] = 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write(dp[i] + " ");
        }
        bw.flush();
    }
}

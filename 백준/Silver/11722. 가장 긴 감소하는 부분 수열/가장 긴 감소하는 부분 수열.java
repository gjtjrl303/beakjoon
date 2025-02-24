import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int max = 0;
            for (int j = i - 1; j > 0; j--) {
                if (num[j] > num[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}

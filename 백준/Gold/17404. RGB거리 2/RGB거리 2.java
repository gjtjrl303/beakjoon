import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.time.chrono.MinguoDate;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static final int RED = 0;
    public static final int GREEN = 1;
    public static final int BLUE = 2;
    public static final int MAX = 10000000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        int[][] colors = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = MAX;
        dp[0][RED] = colors[0][RED];
        dp[0][GREEN] = MAX;
        dp[0][BLUE] = MAX;
        for (int j = 1; j < N; j++) {
            dp[j][RED] = Math.min(dp[j - 1][GREEN], dp[j - 1][BLUE]) + colors[j][RED];
            dp[j][GREEN] = Math.min(dp[j - 1][RED], dp[j - 1][BLUE]) + colors[j][GREEN];
            dp[j][BLUE] = Math.min(dp[j - 1][RED], dp[j - 1][GREEN]) + colors[j][BLUE];
        }
        min = Math.min(dp[N - 1][GREEN], dp[N - 1][BLUE]);

        dp[0][GREEN] = colors[0][GREEN];
        dp[0][RED] = MAX;
        dp[0][BLUE] = MAX;
        for (int j = 1; j < N; j++) {
            dp[j][RED] = Math.min(dp[j - 1][GREEN], dp[j - 1][BLUE]) + colors[j][RED];
            dp[j][GREEN] = Math.min(dp[j - 1][RED], dp[j - 1][BLUE]) + colors[j][GREEN];
            dp[j][BLUE] = Math.min(dp[j - 1][RED], dp[j - 1][GREEN]) + colors[j][BLUE];
        }
        min = Math.min(Math.min(dp[N - 1][RED], dp[N - 1][BLUE]),min);

        dp[0][BLUE] = colors[0][BLUE];
        dp[0][RED] = MAX;
        dp[0][GREEN] = MAX;
        for (int j = 1; j < N; j++) {
            dp[j][RED] = Math.min(dp[j - 1][GREEN], dp[j - 1][BLUE]) + colors[j][RED];
            dp[j][GREEN] = Math.min(dp[j - 1][RED], dp[j - 1][BLUE]) + colors[j][GREEN];
            dp[j][BLUE] = Math.min(dp[j - 1][RED], dp[j - 1][GREEN]) + colors[j][BLUE];
        }
        min = Math.min(Math.min(dp[N - 1][RED], dp[N - 1][GREEN]), min);

        System.out.println(min);
    }
}

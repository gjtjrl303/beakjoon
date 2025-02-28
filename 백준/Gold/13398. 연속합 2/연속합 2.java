import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[n+2];
        int[] leftToRight = new int[n+2];
        int[] rightToLeft = new int[n+2];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        leftToRight[0] = num[0];
        rightToLeft[n - 1] = num[n - 1];

        for (int i = 1; i < n; i++) {
            leftToRight[i] = Math.max(leftToRight[i - 1] + num[i], num[i]);
        }

        for (int i = n-2; i >= 0; i--) {
            rightToLeft[i] = Math.max(rightToLeft[i + 1] + num[i], num[i]);
        }

        int max = leftToRight[0] + rightToLeft[2];

        for (int i = 1; i <= n - 3; i++) {
            max = Math.max(max, leftToRight[i] + rightToLeft[i + 2]);
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, leftToRight[i]);
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, rightToLeft[i]);
        }

        System.out.println(max);
    }
}

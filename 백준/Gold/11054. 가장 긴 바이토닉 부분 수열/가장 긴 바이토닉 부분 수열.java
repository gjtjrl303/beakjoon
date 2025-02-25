import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N + 1];
        int[] forDp = new int[N + 1];
        int[] revDp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        forDp[1] = 1;
        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 1; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, forDp[j]);
                }
            }
            forDp[i] = max + 1;
        }

        revDp[1] = 1;
        for (int i = N; i >=1; i--) {
            int max = 0;
            for (int j = i; j <= N; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, revDp[j]);
                }
            }
            revDp[i] = max + 1;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (max < revDp[i] + forDp[i]) {
                max = revDp[i] + forDp[i];
            }
        }

        System.out.println(max - 1);
    }

}

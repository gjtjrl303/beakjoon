import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX = 1001;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[MAX];
        int[] num = new int[MAX];
        int[] index = new int[MAX];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 0;
            int indexNum = i;
            for (int j = 0; j < i; j++) {
                if (dp[j] > max && num[j] < num[i]) {
                    max = dp[j];
                    indexNum = j;
                }
            }
            dp[i] = max + 1;
            index[i] = indexNum;
        }

        int max = 0;
        int maxIndex = N;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        System.out.println();

        int[] list = new int[MAX];
        int length = 0;
        while (maxIndex != index[maxIndex]) {
            list[length] = num[maxIndex];
            maxIndex = index[maxIndex];
            length++;
        }
        list[length] = num[maxIndex];

            while (length != 0) {
                bw.write(list[length] + " ");
                length--;
            }
            bw.write(list[length] + " ");

            bw.flush();
    }
}

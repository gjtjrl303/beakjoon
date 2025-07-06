
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] numbers = new int[13];
    static int[] output = new int[13];
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i <= N - 6; i++) {
                output[count++] = numbers[i];
                dfs(i);
                count--;
            }
            bw.write("\n");
            bw.flush();
        }

    }

    static void dfs(int startIndex) throws IOException {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(output[i] + " ");
            }
            bw.write("\n");
        }

        for (int i = startIndex + 1; i < N; i++) {
            output[count++] = numbers[i];
            dfs(i);
            count--;
        }
    }
}

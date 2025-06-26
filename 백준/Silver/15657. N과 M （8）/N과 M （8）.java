
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        for (int i = 0; i < N; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder().append(array[i] + " ");
            recursion(i, sb, count + 1);
            bw.flush();
        }

        bw.flush();
    }

    private static void recursion(int i, StringBuilder sb, int count) throws IOException {

        if (count == M) {
            bw.write(sb + "\n");
            return;
        }
        for (int j = i; j < N; j++) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(array[j] + " ");
            recursion(j, newSb, count + 1);
        }
    }
}

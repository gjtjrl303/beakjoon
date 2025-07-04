
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int N, M;
    static int[] array;
    static Set<String> set = new LinkedHashSet<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count = 0;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);

        for (int i = 0; i < N; i++) {
            count++;
            StringBuilder sb = new StringBuilder();
            sb.append(array[i] + " ");
            dfs(i, sb);
            count--;
        }

        bw.flush();

    }

    private static void dfs(int start, StringBuilder sb) throws IOException {
        if (count == M) {
            if (set.add(String.valueOf(sb))) {
                bw.write(sb + "\n");
            }
            return;
        }

        for (int i = start + 1; i < N; i++) {
            count++;
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(array[i]+" ");
            dfs(i, newSb);
            count--;
        }
    }
}


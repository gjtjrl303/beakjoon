
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int N, M;
    static Set<String> set = new LinkedHashSet<>();
    static int[] array;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            count++;
            sb.append(array[i] + " ");
            dfs(sb, i);
            count--;
        }

        for (String s : set) {
            bw.write(s + "\n");
        }
        bw.flush();

    }

    private static void dfs(StringBuilder sb,int start) {
        if (count == M) {
            set.add(String.valueOf(sb));
            return;
        }

        for (int i = start; i < N; i++) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(array[i] + " ");
            count++;
            dfs(newSb, i);
            count--;
        }
    }
}

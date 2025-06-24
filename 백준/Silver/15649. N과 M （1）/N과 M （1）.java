
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static Scanner scanner = new Scanner(System.in);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        N = scanner.nextInt();
        M = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder().append(i + " ");
            boolean[] used = new boolean[N + 1];
            used[i] = true;
            recursion(sb, count + 1, used);
        }
        bw.flush();
    }

    private static void recursion(StringBuilder sb, int count, boolean[] used) throws IOException {

        if (count == M) {
            bw.write(sb + "\n");
            bw.flush();
            return;
        }
        for (int j = 1; j <= N; j++) {
            boolean[] newUsed = Arrays.copyOf(used, used.length);
            if (!newUsed[j]) {
                newUsed[j] = true;
                StringBuilder newSb = new StringBuilder(sb);
                newSb.append(j + " ");

                recursion(newSb, count + 1, newUsed);
            }
        }
    }
}

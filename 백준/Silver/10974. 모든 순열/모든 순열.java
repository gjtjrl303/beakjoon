
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] used;
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        used = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            int count = 0;
            used[i] = true;
            StringBuilder sb = new StringBuilder().append(i + " ");
            recursion(sb, count + 1);
            used[i] = false;
        }
        bw.flush();
    }

    private static void recursion(StringBuilder sb, int count) throws IOException {
        if (count == N) {
            bw.write(sb + "\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                StringBuilder newSb = new StringBuilder(sb).append(i + " ");
                recursion(newSb, count + 1);
                used[i] = false;
            }
        }
    }
}

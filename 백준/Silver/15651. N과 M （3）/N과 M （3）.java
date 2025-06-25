
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
            recursion(i, sb, count + 1);
        }
        bw.flush();
    }

    private static void recursion(int i, StringBuilder sb, int count) throws IOException {

        if (count == M) {
            bw.write(sb + "\n");
            return;
        }
        for (int j = 1; j <= N; j++) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(j + " ");

            recursion(j, newSb, count + 1);
        }
    }
}

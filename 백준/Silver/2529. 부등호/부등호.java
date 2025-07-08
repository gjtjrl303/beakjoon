
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static char[] symbol;
    static Long min = 9999999999L;
    static Long max = 0L;
    static int N;
    static int count = 0;
    static boolean[] visited = new boolean[10];
    static int[] output;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        output = new int[N + 1];
        symbol = new char[N];
        scanner.nextLine();
        StringTokenizer st = new StringTokenizer(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            symbol[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            output[count++] = i;
            dfs();
            visited[i] = false;
            count--;
        }
        DecimalFormat df = new DecimalFormat(String.format("%0" + (N+1) + "d", 0));

        System.out.println(df.format(max));
        System.out.println(df.format(min));
    }

    private static void dfs() {
        if (count == N + 1) {
            if (checkOutput()) {
                Long num = digitsToNumber();
                max = Math.max(num, max);
                min = Math.min(num, min);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            output[count++] = i;
            dfs();
            visited[i] = false;
            count--;
        }
    }

    private static Long digitsToNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + 1; i++) {
            sb.append(output[i]);
        }
        return Long.parseLong(String.valueOf(sb));
    }

    private static boolean checkOutput() {
        for (int i = 0; i < N; i++) {
            if ((symbol[i] == '>' && output[i] < output[i + 1])) {
                return false;
            }
            if ((symbol[i] == '<' && output[i] > output[i + 1])) {
                return false;
            }
        }
        return true;
    }
}

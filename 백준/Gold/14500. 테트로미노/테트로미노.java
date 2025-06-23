
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[][] numbers;

    public static void main(String[] args) throws IOException {

        int max = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        numbers = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(poly1(i, j), max);
                max = Math.max(poly1Left(i, j), max);
                max = Math.max(poly2(i, j), max);
                max = Math.max(poly3(i, j), max);
                max = Math.max(poly3Left(i, j), max);
            }
        }

        System.out.println(max);
    }

    public static int poly1(int n, int m) {
        if (validate(n, n, m, m + 3)) {
            return numbers[n][m] + numbers[n][m + 1] + numbers[n][m + 2] + numbers[n][m + 3];
        }
        return 0;
    }

    public static int poly1Left(int n, int m) {
        if (validate(n, n + 3, m, m)) {
            return numbers[n][m] + numbers[n + 1][m] + numbers[n + 2][m] + numbers[n + 3][m];
        }
        return 0;
    }

    public static int poly2(int n, int m) {
        if (validate(n, n + 1, m, m + 1)) {
            return numbers[n][m] + numbers[n][m + 1] + numbers[n + 1][m] + numbers[n + 1][m + 1];
        }
        return 0;
    }

    public static int poly3(int n, int m) {
        if (validate(n, n + 2, m, m + 1)) {
            int max = 0;
            int sum = numbers[n][m] + numbers[n][m + 1] + numbers[n + 1][m] + numbers[n + 1][m + 1] + numbers[n + 2][m] + numbers[n + 2][m + 1];

            int case1 = numbers[n][m] + numbers[n + 1][m];
            int case2 = numbers[n][m+1] + numbers[n + 1][m + 1];
            int case3 = numbers[n + 1][m] + numbers[n + 2][m];
            int case4 = numbers[n + 1][m + 1] + numbers[n + 2][m + 1];
            max = Math.max(sum - case1, max);
            max = Math.max(sum - case2, max);
            max = Math.max(sum - case3, max);
            max = Math.max(sum - case4, max);

            case1 = numbers[n][m] + numbers[n + 2][m + 1];
            case2 = numbers[n][m + 1] + numbers[n + 2][m];
            max = Math.max(sum - case1, max);
            max = Math.max(sum - case2, max);

            case1 = numbers[n][m + 1] + numbers[n + 2][m + 1];
            case2 = numbers[n][m] + numbers[n + 2][m];
            max = Math.max(sum - case1, max);
            max = Math.max(sum - case2, max);
            return max;
        }
        return 0;
    }

    public static int poly3Left(int n, int m) {
        if (validate(n, n + 1, m, m + 2)) {
            int max = 0;
            int sum = numbers[n][m] + numbers[n][m + 1] + numbers[n][m + 2] + numbers[n + 1][m] + numbers[n + 1][m + 1] + numbers[n + 1][m + 2];

            int case1 = numbers[n][m] + numbers[n][m + 1];
            int case2 = numbers[n + 1][m] + numbers[n + 1][m + 1];
            int case3 = numbers[n][m + 1] + numbers[n][m + 2];
            int case4 = numbers[n + 1][m + 1] + numbers[n + 1][m + 2];
            max = Math.max(sum - case1, max);
            max = Math.max(sum - case2, max);
            max = Math.max(sum - case3, max);
            max = Math.max(sum - case4, max);

            case1 = numbers[n][m] + numbers[n + 1][m + 2];
            case2 = numbers[n + 1][m] + numbers[n][m + 2];
            max = Math.max(sum - case1, max);
            max = Math.max(sum - case2, max);

            case1 = numbers[n][m] + numbers[n][m + 2];
            case2 = numbers[n + 1][m] + numbers[n + 1][m + 2];
            max = Math.max(sum - case1, max);
            max = Math.max(sum - case2, max);
            return max;
        }
        return 0;
    }

    private static boolean validate(int n1, int n2, int m1, int m2) {
        return n1 >= 0 && n2 < N && m1 >= 0 && m2 < M;
    }
}

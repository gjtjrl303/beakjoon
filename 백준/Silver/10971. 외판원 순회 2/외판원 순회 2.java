
import java.security.Key;
import java.util.Scanner;

public class Main {

    static boolean[] visited;
    static int N;
    static int[][] W;
    static int max = 100000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                W[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            int sum = 0;
            int count = 0;
            dfs(i, i, sum, count + 1);
            visited[i] = false;
        }

        System.out.println(max);

    }

    private static void dfs(int startCity, int previousCity, int sum, int visitedCityCount) {
        if (visitedCityCount == N) {
            if (W[previousCity][startCity] != 0) {
                max = Math.min(sum + W[previousCity][startCity], max);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            if (W[previousCity][i] != 0) {
                visited[i] = true;
                dfs(startCity, i, sum + W[previousCity][i], visitedCityCount + 1);
                visited[i] = false;
            }
        }
    }
}

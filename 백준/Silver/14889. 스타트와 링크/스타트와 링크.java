
import java.util.Scanner;

public class Main {

    static int[][] num;
    static int[] team;
    static int N;
    static int sum;
    static int count = 0;
    static int min = 1000000;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        num = new int[N][N];
        team = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                num[i][j] = scanner.nextInt();
                sum += num[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            team[i] = 1;
            count++;
            dfs(i);
            team[i] = 0;
            count--;
        }

        System.out.println(min);
    }

    static void dfs(int start) {
        if (count == N / 2) {
            calculateSum();
        }

        for (int i = start + 1; i < N; i++) {
            team[i] = 1;
            count++;
            dfs(i);
            team[i] = 0;
            count--;
        }
    }

    static void calculateSum() {
        int teamSum = 0;
        int otherTeam = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (team[i] == team[j] && team[i] == 1) {
                    teamSum += num[i][j];
                }
                if (team[i] == team[j] && team[i] == 0) {
                    otherTeam += num[i][j];
                }
            }
        }
        min = Math.min(min, Math.abs(otherTeam - teamSum));
    }
}


import java.util.List;
import java.util.Scanner;

public class Main {

    static char[][] Chess1 = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};

    static char[][] Chess2 = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};

    static char[][] input;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int min = 65;
        input = new char[N][M];
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                input[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                min = Math.min(min, checkNoMatch(i, j));
            }
        }
        min = Math.min(min, checkNoMatch(0, 0));

        System.out.println(min);

    }

    private static int checkNoMatch(int i, int j) {
        int xIndex = 0;
        int yIndex = 0;
        int count = 0;

        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if (Chess1[xIndex][yIndex] != input[k][l]) {
                    count++;
                }
                yIndex++;
            }
            xIndex++;
            yIndex = 0;
        }

        int temp = count;

        xIndex = 0;
        yIndex = 0;
        count = 0;

        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if (Chess2[xIndex][yIndex] != input[k][l]) {
                    count++;
                }
                yIndex++;
            }
            xIndex++;
            yIndex = 0;
        }
        return Math.min(count, temp);
    }
}

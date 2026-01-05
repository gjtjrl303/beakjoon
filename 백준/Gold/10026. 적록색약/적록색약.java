
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int[] directionX = {-1, 0, 1, 0};
    public static int[] directionY = {0, -1, 0, 1};
    public static char[][] grid1;
    public static char[][] grid2;
    public static boolean[][] visited1;
    public static boolean[][] visited2;
    public static int count1 = 0;
    public static int count2 = 0;
    public static int N;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        scanner.nextLine();
        grid1 = new char[N][N];
        grid2 = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] charArray = scanner.nextLine().toCharArray();
            for (int j = 0; j < N; j++) {
                grid1[i][j] = charArray[j];
                if (charArray[j] == 'G') {
                    grid2[i][j] = 'R';
                } else {
                    grid2[i][j] = charArray[j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    bfs1(i, j);
                    count1++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited2[i][j]) {
                    bfs2(i, j);
                    count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);
    }

    private static void bfs1(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        visited1[x][y] = true;

        while (!queue.isEmpty()) {
            Point remove = queue.remove();
            for (int i = 0; i < 4; i++) {
                int newX = remove.x + directionX[i];
                int newY = remove.y + directionY[i];
                if (validate(newX, newY) && validateSame(grid1[newX][newY], grid1[remove.x][remove.y]) && !visited1[newX][newY]){
                    queue.add(new Point(newX,newY));
                    visited1[newX][newY] = true;
                }
            }
        }
    }

    private static void bfs2(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        visited2[x][y] = true;

        while (!queue.isEmpty()) {
            Point remove = queue.remove();
            for (int i = 0; i < 4; i++) {
                int newX = remove.x + directionX[i];
                int newY = remove.y + directionY[i];
                if (validate(newX, newY) && validateSame(grid2[newX][newY], grid2[remove.x][remove.y]) && !visited2[newX][newY]){
                    queue.add(new Point(newX,newY));
                    visited2[newX][newY] = true;
                }
            }
        }
    }

    private static boolean validateSame(char c, char c1) {
        return c == c1;
    }

    private static boolean validate(int newX, int newY) {
        return 0 <= newX && newX < N && 0 <= newY && newY < N;
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

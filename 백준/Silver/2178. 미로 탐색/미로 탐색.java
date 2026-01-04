
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static int[] directionX = {-1, 0, 1, 0};
    public static int[] directionY = {0, -1, 0, 1};
    public static Queue<Point> queue = new ArrayDeque<>();
    public static boolean[][] visited;
    public static int[][] maze;
    public static int N, M;
    public static int count = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = charArray[j] - '0';
            }
        }
        Point point = new Point(0, 0);
        queue.add(point);
        visited[0][0] = true;
        bfs();

    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Point remove = queue.remove();
                if (remove.x == N - 1 && remove.y == M - 1) {
                    System.out.println(count);
                    System.exit(0);
                }

                for (int i = 0; i < 4; i++) {
                    int x = remove.getX() + directionX[i];
                    int y = remove.getY() + directionY[i];
                    if (!validate(x, y)) continue;

                    visited[x][y] = true;
                    queue.add(new Point(x, y));
                }
            }
            count++;
        }
    }

    private static boolean validate(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M && maze[x][y] == 1 && !visited[x][y];
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

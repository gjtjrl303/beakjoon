
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] matrix;
    public static boolean[][] visited;
    public static int N;
    public static List<Integer> countList = new ArrayList<>();

    public static int[] directionX = {0, -1, 0, 1};
    public static int[] directionY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && matrix[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(countList.size());
        Collections.sort(countList);
        for (Integer i : countList) {
            System.out.println(i);
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<Point> queue = new ArrayDeque<>();
        int count = 0;

        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point remove = queue.remove();
            count++;
            int x = remove.getX();
            int y = remove.getY();
            for (int i = 0; i < 4; i++) {
                int targetX = x + directionX[i];
                int targetY = y + directionY[i];
                if (validate(targetX, targetY) && !visited[targetX][targetY] && matrix[targetX][targetY] != 0) {
                    queue.add(new Point(targetX, targetY));
                    visited[targetX][targetY] = true;
                }
            }
        }

        countList.add(count);
    }

    private static boolean validate(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int x;

        private int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) return false;
            Point point = (Point) object;
            return getX() == point.getX() && getY() == point.getY();
        }
    }
}

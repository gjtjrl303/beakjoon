
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M, K;
        int[][] board;
        boolean[][] isVisited;
        int count = 0, size = 0;
        int x, y;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Point> queue = new ArrayDeque<>();

        board = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        queue.add(new Point(0, 0));
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.getY() == N - 1 && point.getX() == M - 1) {
                    System.out.println(count);
                    return;
                }
                x = point.getX();
                y = point.getY();

                if (y % 2 != 0) {
                    if (point.getY() - 1 >= 0) {
                        if (point.getX() >= 0 && board[y - 1][x] != 1 && !isVisited[y - 1][x]) {
                            isVisited[y-1][x] = true;
                            queue.add(new Point(point.getY() - 1, point.getX()));
                        }
                        if (point.getX() + 1 < M && board[y - 1][x + 1] != 1 && !isVisited[y - 1][x + 1]) {
                            isVisited[y-1][x+1] = true;
                            queue.add(new Point(point.getY() - 1, point.getX() + 1));
                        }
                    }
                    if (point.getY() + 1 < N) {
                        if (point.getX() >= 0 && board[y + 1][x] != 1 && !isVisited[y + 1][x]) {
                            isVisited[y+1][x] = true;
                            queue.add(new Point(point.getY() + 1, point.getX()));
                        }
                        if (point.getX() + 1 < M && board[y + 1][x + 1] != 1 && !isVisited[y + 1][x + 1]) {
                            isVisited[y+1][x+1] = true;
                            queue.add(new Point(point.getY() + 1, point.getX() + 1));
                        }
                    }
                    if (point.getX() - 1 >= 0 && board[y][x - 1] != 1 && !isVisited[y][x - 1]) {
                        isVisited[y][x-1] = true;
                        queue.add(new Point(point.getY(), point.getX() - 1));
                    }
                    if (point.getX() + 1 < M && board[y][x + 1] != 1 && !isVisited[y][x + 1]) {
                        isVisited[y][x+1] = true;
                        queue.add(new Point(point.getY(), point.getX() + 1));
                    }
                } else {
                    if (point.getY() - 1 >= 0) {
                        if (point.getX() - 1 >= 0 && board[y - 1][x - 1] != 1 && !isVisited[y - 1][x - 1]) {
                            isVisited[y-1][x-1] = true;
                            queue.add(new Point(point.getY() - 1, point.getX() - 1));
                        }
                        if (point.getX() < M && board[y - 1][x] != 1 && !isVisited[y - 1][x]) {
                            isVisited[y - 1][x] = true;
                            queue.add(new Point(point.getY() - 1, point.getX()));
                        }
                    }
                    if (point.getY() + 1 < N) {
                        if (point.getX() - 1 >= 0 && board[y + 1][x - 1] != 1 && !isVisited[y + 1][x - 1]) {
                            isVisited[y+1][x-1] = true;
                            queue.add(new Point(point.getY() + 1, point.getX() - 1));
                        }
                        if (point.getX() < M && board[y + 1][x] != 1 && !isVisited[y + 1][x]) {
                            isVisited[y+1][x] = true;
                            queue.add(new Point(point.getY() + 1, point.getX()));
                        }
                    }
                    if (point.getX() - 1 >= 0 && board[y][x - 1] != 1 && !isVisited[y][x - 1]) {
                        isVisited[y][x-1] = true;
                        queue.add(new Point(point.getY(), point.getX() - 1));
                    }
                    if (point.getX() + 1 < M && board[y][x + 1] != 1 && !isVisited[y][x + 1]) {
                        isVisited[y][x+1] = true;
                        queue.add(new Point(point.getY(), point.getX() + 1));
                    }
                }

            }
            count++;
        }
        System.out.println(-1);
    }

    static class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}

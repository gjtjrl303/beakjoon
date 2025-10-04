
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int[] xDir = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static int[] yDir = {-1, -1, -1, 0, 1, 1, 1 ,0};


    public static boolean[][] isLight;
    public static char[][] room;
    public static Ari ari = new Ari();
    public static int N;

    public static List<Zombi> zombis = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        char[] command = scanner.next().toCharArray();

        isLight = new boolean[N][N];
        room = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] charArray = scanner.next().toCharArray();
            for (int j = 0; j < N; j++) {
                room[i][j] = charArray[j];

                if (charArray[j] == 'Z') {
                    zombis.add(new Zombi(i, j));
                }
            }
        }

        for (char c : command) {
            if (c == 'F') {
                ari.Forward();
            } else if (c == 'R') {
                ari.right();
            } else if (c == 'L') {
                ari.left();
            }

            for (Zombi zombi : zombis) {
                zombi.move();
            }

//            int[][] stage = new int[N][N];
//            stage[ari.x][ari.y] = 3;
//            for (Zombi zombi : zombis) {
//                stage[zombi.x][zombi.y] = 2;
//            }
//
//             for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (isLight[i][j]) {
//                        stage[i][j] = 1;
//                    }
//                }
//                System.out.println();
//            }
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(stage[i][j]);
//                }
//                System.out.println();
//            }
//
//
//            System.out.println("======================================");

        }

        if (ari.isFaint) System.out.println("Aaaaaah!");
        else System.out.println("Phew...");
    }

    static class Ari {
        int x = 0;
        int y = 0;
        boolean isFaint;
        Direction direction = Direction.DOWN;

        public void Forward() {
                if (valid(direction.x + x) && valid(direction.y + y)) {
                    x += direction.x;
                    y += direction.y;
                }

            if (room[x][y] == 'S') {
                OnLight();
            }
        }

        public void left() {
            direction = direction.rotateLeft();
        }

        public void right() {
            direction = direction.rotateRight();
        }

        private void OnLight() {
            for (int i = 0; i < 8; i++) {
                if (valid(x + xDir[i]) && valid(y + yDir[i])) {
                    isLight[x + xDir[i]][y + yDir[i]] = true;
                }
            }
            isLight[x][y] = true;
        }

        private boolean valid(int i) {
            return i >= 0 && i < N;
        }
    }

    static class Zombi {
        int x;
        int y;
        boolean downDirection;

        public Zombi(int x, int y) {
            this.x = x;
            this.y = y;
            this.downDirection = true;
        }

        public void move() {

            if (x == ari.x && y == ari.y && !isLight[x][y]) {
                ari.isFaint = true;
            }

            if (x == N - 1 && downDirection == true) {
                downDirection = false;
                return;
            }
            if (x == 0 && downDirection == false) {
                downDirection = true;
                return;
            }

            if (downDirection) x++;
            else x--;

            if (x == ari.x && y == ari.y && !isLight[x][y]) {
                ari.isFaint = true;
            }
        }
    }

    enum Direction {
        DOWN(+1, 0),
        LEFT(0, -1),
        UP(-1, 0),
        RIGHT(0, 1);

        public int x;
        public int y;

        Direction(int x, int y) {
            this.x = x;
            this.y= y;
        }


        public Direction rotateRight() {
            return values()[(this.ordinal() + 1) % 4];
        }

        public Direction rotateLeft() {
            return values()[(this.ordinal() + 3) % 4];
        }

    }
}

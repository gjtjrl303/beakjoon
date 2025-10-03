
import java.util.Scanner;

public class Main {

    public static int I;
    public static int N;
    public static int K;

    public static char[] colors;
    public static char[][] stage;

    public static Player player;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        I = scanner.nextInt();
        N = scanner.nextInt();
        K = scanner.nextInt();

        colors = scanner.next().toCharArray();
        stage = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] charArray = scanner.next().toCharArray();
            for (int j = 0; j < N; j++) {
                if (charArray[j] == '@') {
                    player = new Player(i, j);
                    stage[i][j] = '.';
                }else stage[i][j] = charArray[j];
            }
        }
//
//        System.out.println();
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(stage[i][j]);
//            }
//            System.out.println();
//        }

        char[] charArray = scanner.next().toCharArray();

        for (char c : charArray) {
            if(c=='U') {
                player.moveUp();
            } else if (c == 'D') {
                player.moveDown();
            } else if (c == 'L'){
                player.moveLeft();
            } else if (c == 'R') {
                player.moveRight();
            } else if (c == 'j') {
                player.ink();
            } else if (c == 'J') {
                player.jump();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == player.x && j == player.y) System.out.print("@");
                else System.out.print(stage[i][j]);
            }
            System.out.println();
        }
    }

    static class Player{
        int x;
        int y;
        int inkCount;
        int jumpCount;

        public Player(int x, int y) {
            this.x = x;
            this.y = y;
            inkCount = 0;
            jumpCount = 0;
        }

        public void moveUp() {
            if (x > 0 && (stage[x - 1][y] == '.')) {
                x--;
            }
        }

        public void moveDown() {
            if (x < N-1 && (stage[x+1][y] == '.')) {
                x++;
            }
        }
        public void moveLeft() {
            if (y > 0 && (stage[x][y-1] == '.')) {
                y--;
            }
        }
        public void moveRight() {
            if (y < N-1 && (stage[x][y+1] == '.')) {
                y++;
            }
        }

        public void ink() {
            inkCount++;
        }

        public void jump() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (stage[i][j] != '.') {
                        if (Math.abs(x - i) + Math.abs(y - j) <= inkCount) {
                            stage[i][j] = colors[jumpCount % (colors.length)];
                        }
                    }
                }
            }
            jumpCount++;
            inkCount = 0;
        }
    }
}

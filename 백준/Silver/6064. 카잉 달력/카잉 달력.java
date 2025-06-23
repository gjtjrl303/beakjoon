
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        int T, N, M, x, y;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            System.out.println(calculateYear(N, M, x, y));
        }

    }

    private static int calculateYear(int N, int M, int x, int y) {
        int tempX = 1, tempY = 1, year = 1;
        while (true) {


            if (tempX == x && tempY == y) {
                return year;
            }

            if (tempX - tempY != x - y) {
                if (N - tempX < M - tempY) {
                    int temp = N - tempX + 1;
                    tempX += temp;
                    tempY += temp;
                    year += temp;
                } else {
                    int temp = M - tempY + 1;
                    tempX += temp;
                    tempY += temp;
                    year += temp;
                }
            } else {
                tempX++;
                tempY++;
                year++;
            }

            if (tempX == N + 1) {
                tempX = 1;
            }
            if (tempY == M + 1) {
                tempY = 1;
            }

            if (tempX == 1 && tempY == 1) {
                return -1;
            }
        }
    }
}

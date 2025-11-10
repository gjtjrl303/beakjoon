
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int N, D;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int x = 0, y = 0;
        int min = 1000000;

        int[][] magnetic = new int[N][N];
        int[][] magneticIsHere = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int isMagnetic = Integer.parseInt(st.nextToken());
                if (isMagnetic == 1) {
                    magneticIsHere[i][j] = 1;
                    int xStart = Math.max(j - D, 0);
                    int xEnd = Math.min(j + D, N - 1);

                    int yStart = Math.max(i - D, 0);
                    int yEnd = Math.min(i + D, N - 1);

                    for (int k = yStart; k <= yEnd; k++) {
                        for (int l = xStart; l <= xEnd; l++) {
                            magnetic[k][l]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (min > magnetic[i][j] && magneticIsHere[i][j] != 1) {
                    x = j;
                    y = i;
                    min = magnetic[i][j];
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(magnetic[i][j] + " ");
//            }
//            System.out.println();
//        }

        if (min == 0) {
            bw.write((y + 1) + " " + (x + 1));
        } else {
            bw.write((y + 1) + " " + (x + 1) + "\n");
            bw.write( "" + min);
        }
        bw.flush();
    }
}

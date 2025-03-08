import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] Bomboni = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                Bomboni[i][j] = str.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {

                    if (Bomboni[i][j] != Bomboni[i][j + 1]) {
                        char temp = Bomboni[i][j];
                        Bomboni[i][j] = Bomboni[i][j + 1];
                        Bomboni[i][j + 1] = temp;

                        for (int k = 0; k < N; k++) {
                            int count = 0;
                            Character prevChar = 'a';
                            for (int l = 0; l < N; l++) {
                                if (prevChar != Bomboni[k][l]) {
                                    prevChar = Bomboni[k][l];
                                    count = 1;
                                } else {
                                    count++;
                                }
                                max = Math.max(count, max);
                            }

                            count = 0;
                            prevChar = 'a';
                            for (int l = 0; l < N; l++) {
                                if (prevChar != Bomboni[l][k]) {
                                    prevChar = Bomboni[l][k];
                                    count = 1;
                                } else {
                                    count++;
                                }
                                max = Math.max(count, max);
                            }
                        }

                        temp = Bomboni[i][j];
                        Bomboni[i][j] = Bomboni[i][j + 1];
                        Bomboni[i][j + 1] = temp;
                    }
                }
                if (i + 1 < N) {

                    if (Bomboni[i][j] != Bomboni[i + 1][j]) {
                        char temp = Bomboni[i][j];
                        Bomboni[i][j] = Bomboni[i + 1][j];
                        Bomboni[i + 1][j] = temp;

                        for (int k = 0; k < N; k++) {
                            int count = 0;
                            Character prevChar = 'a';
                            for (int l = 0; l < N; l++) {
                                if (prevChar != Bomboni[k][l]) {
                                    prevChar = Bomboni[k][l];
                                    count = 1;
                                } else {
                                    count++;
                                }
                                max = Math.max(count, max);
                            }

                            count = 0;
                            prevChar = 'a';
                            for (int l = 0; l < N; l++) {
                                if (prevChar != Bomboni[l][k]) {
                                    prevChar = Bomboni[l][k];
                                    count = 1;
                                } else {
                                    count++;
                                }
                                max = Math.max(count, max);
                            }
                        }

                        temp = Bomboni[i][j];
                        Bomboni[i][j] = Bomboni[i + 1][j];
                        Bomboni[i + 1][j] = temp;
                    }
                }
            }

        }
        System.out.println(max);
    }
}

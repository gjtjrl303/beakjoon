
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[] numbers;
    static int N;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        numbers = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        previous();

        if (flag) {
            for (int i = 0; i < N; i++) {
                System.out.print(numbers[i] + " ");
            }
        } else {
            System.out.println(-1);
        }

    }

    private static void previous() {

        int i = N - 1;
        for (; i > 0; i--) {
            if (numbers[i] < numbers[i - 1]) {
                break;
            }
        }

        if (i == 0) {
            return;
        }

        for (int j = N - 1; j >= i; j--) {
            if (numbers[j] < numbers[i - 1]) {
                swap(j, i - 1);
                break;
            }
        }

        Arrays.sort(numbers, i, N, Collections.reverseOrder());
        flag = true;
    }

    public static void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

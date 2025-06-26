
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        int N;
        int[] array;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int i = N - 1;
        boolean flag = false;

        for (; i > 0; i--) {
            if (array[i - 1] < array[i]) {
                int min = 100000;
                int minIndex = 0;
                for (int j = N - 1; j >= i; j--) {
                    if (array[j] < min && array[j] > array[i - 1]) {
                        min = array[j];
                        minIndex = j;
                    }
                }
                int temp = array[i - 1];
                array[i - 1] = min;
                array[minIndex] = temp;
                flag = true;
                break;
            }
        }
        Arrays.sort(array, i, N);

        if (!flag) {
            System.out.println(-1);
        } else {
            for (int j = 0; j < N; j++) {
                System.out.print(array[j] + " ");
            }
        }
    }
}

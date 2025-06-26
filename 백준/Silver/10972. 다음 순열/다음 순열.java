import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] used;
    static int[] targetArray;
    static int[] array;
    static int N;
    static boolean search = false;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        array = new int[N];
        targetArray = new int[N];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            targetArray[i] = Integer.parseInt(st.nextToken());
        }
        array = Arrays.copyOf(targetArray, N);
        Arrays.sort(array);


        for (int i = 0; i < N; i++) {
            int index = 0;
            if (array[i] >= targetArray[index]) {
                used[i] = true;
                StringBuilder sb = new StringBuilder();
                sb.append(array[i] + " ");
                recursion(index + 1, sb);
                used[i] = false;
            }
        }

        if (!flag) {
            System.out.println(-1);
        } else {
            bw.flush();
        }
    }

    private static void recursion(int index, StringBuilder sb) throws IOException {

        if (flag) {
            return;
        }

        if (index == N && search) {
            bw.write(String.valueOf(sb));
            flag = true;
        }
        if (index == N) {
            search = true;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!search) {
                if (array[i] == targetArray[index]) {
                    used[i] = true;
                    StringBuilder newSt = new StringBuilder(sb);
                    newSt.append(array[i] + " ");
                    recursion(index + 1, newSt);
                    used[i] = false;
                }
            } else {
                if (!used[i]) {
                    used[i] = true;
                    StringBuilder newSt = new StringBuilder(sb);
                    newSt.append(array[i] + " ");
                    recursion(index + 1, newSt);
                    used[i] = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }
}

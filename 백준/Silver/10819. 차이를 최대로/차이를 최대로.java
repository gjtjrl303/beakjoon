
import java.util.Scanner;

public class Main {

    static int[] array;
    static int max = 0;
    static int N;
    static boolean[] used;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        array = new int[N];
        used = new boolean[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            int index = 0;
            used[i] = true;
            recursion(sum, 1 + index, array[i]);
            used[i] = false;
        }
        System.out.println(max);
    }

    private static void recursion(int sum, int index, int previous) {
        if (index == N) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            recursion(sum + Math.abs(previous - array[i]), 1 + index, array[i]);
            used[i] = false;
        }
    }
}

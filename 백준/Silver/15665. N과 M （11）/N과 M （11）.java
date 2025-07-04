import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        Set<Integer> set = new TreeSet<>(); // 중복 제거 + 자동 정렬
        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }
        nums = set.stream().mapToInt(Integer::intValue).toArray(); // 중복 제거된 배열
        output = new int[M];

        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            output[depth] = nums[i]; // 중복 선택 허용
            dfs(depth + 1);
        }
    }
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<List<Integer>> matrix;
    private static boolean[] visited;
    private static int[] rank;
    private static int count = 1;
    private static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        rank = new int[N];
        matrix = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            matrix.get(u - 1).add(v);
            matrix.get(v - 1).add(u);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(matrix.get(i));
        }

        dfs(R);

        for (int i = 0; i < N; i++) {
            bw.write(rank[i] + "\n");
        }
        bw.flush();
    }

    private static void dfs(int R) {
        if (visited[R - 1]) {
            return;
        }

        visited[R - 1] = true;
        rank[R - 1] = count++;

        List<Integer> integers = matrix.get(R - 1);
        for (Integer integer : integers) {
            dfs(integer);
        }
    }
}

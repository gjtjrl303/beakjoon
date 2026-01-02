
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static int N, M;
    private static int count = 0;
    private static boolean[] visited;
    private static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            graph.get(vertex1 - 1).add(vertex2 - 1);
            graph.get(vertex2 - 1).add(vertex1 - 1);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                BFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void BFS(int i) {
        while (!queue.isEmpty()) {
            Integer removedVertex = queue.remove();
            List<Integer> integers = graph.get(removedVertex);
            for (Integer integer : integers) {
                if (!visited[integer]) {
                    queue.add(integer);
                    visited[integer] = true;
                }
            }
        }
    }
}

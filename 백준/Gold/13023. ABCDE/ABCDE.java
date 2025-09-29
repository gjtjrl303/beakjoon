
import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] isFriend;
    static boolean[] visited = new boolean[2000];
    static boolean flag = false;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isFriend = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            isFriend[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isFriend[a].add(b);
            isFriend[b].add(a);
        }

        for (int i = 0; i < isFriend.length; i++) {
            List<Integer> list = isFriend[i];
            for (Integer integer : list) {
                if (!visited[integer]) {
                    visited[i] = true;
                    visited[integer] = true;
                    dfs(isFriend[integer], 2);
                    visited[integer] = false;
                    visited[i] = false;
                }
            }
        }

        if (!flag) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    private static void dfs(ArrayList<Integer> list, int depth) {
        for (Integer integer : list) {
            if (depth == 5) {
                flag = true;
                return;
            }
            if (!visited[integer]) {
                visited[integer] = true;
                dfs(isFriend[integer], depth + 1);
                visited[integer] = false;
            }
            if (flag) break;
        }
    }
}

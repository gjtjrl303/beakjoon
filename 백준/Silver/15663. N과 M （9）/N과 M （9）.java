
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] array;
    static HashSet<String> hashSet = new HashSet<>();
    static int count = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            sb.append(array[i] + " ");
            count++;
            recursion(list, i, sb);
            count--;
        }

        bw.flush();
    }

    private static void recursion(List<Integer> indexList, int j,StringBuilder sb) throws IOException {
        if (count == M) {
            if (hashSet.add(String.valueOf(sb))) {
                bw.write(sb + "\n");
            }
            return;
        }

        for (int i = 0; i < N ; i++) {
            if (indexList.contains(i)) {
                continue;
            }
            ArrayList<Integer> newIndexList = new ArrayList<>(indexList);
            newIndexList.add(i);
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(array[i] + " ");
            count++;
            recursion(newIndexList, i, newSb);
            count--;
        }

    }
}

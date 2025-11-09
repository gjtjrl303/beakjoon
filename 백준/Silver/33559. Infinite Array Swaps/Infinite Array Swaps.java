
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> listA = new LinkedList<>(), listB = new LinkedList<>();
        List<Integer> resultA = new LinkedList<>(), resultB = new LinkedList<>();
        int count = 0;

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            listB.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(listA);
        Collections.sort(listB);

        ArrayDeque<Integer> integersA = new ArrayDeque<>(listA);
        ArrayDeque<Integer> integersB = new ArrayDeque<>(listB);

        while (!integersA.isEmpty() && !integersB.isEmpty()) {
            if (integersA.peekFirst().equals(integersB.peekFirst())) {
                resultA.add(0,integersA.pollFirst());
                resultB.add(0, integersB.pollFirst());
                count++;
            } else if (integersA.peekFirst() < integersB.peekFirst()) {
                resultA.add(resultA.size(), integersA.pollFirst());
            } else if (integersA.peekFirst() > integersB.peekFirst()) {
                resultB.add(resultB.size(), integersB.pollFirst());
            }
        }

        while (!integersA.isEmpty()) {
            resultA.add(integersA.pollFirst());
        }

        while (!integersB.isEmpty()) {
            resultB.add(integersB.pollFirst());
        }

        bw.write(count + "\n");
        for (Integer i : resultA) {
            bw.write(i + " ");
        }
        bw.write("\n");

        for (Integer i : resultB) {
            bw.write(i + " ");
        }
        bw.flush();

    }
}

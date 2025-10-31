
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Deque<String> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1;
        StringTokenizer st2;
        int result = 0;
        int N = Integer.parseInt(br.readLine());

        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            if (st1.nextToken().equals("1")) {
                st2.nextToken();
            } else {
                deque.addLast(st2.nextToken());
            }
        }

        N = Integer.parseInt(br.readLine());
        st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            deque.addFirst(st1.nextToken());
            bw.write(deque.removeLast() + " ");
        }
        bw.flush();
    }
}

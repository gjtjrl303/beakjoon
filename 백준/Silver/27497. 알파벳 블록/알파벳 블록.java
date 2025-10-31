
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Deque<String> deque = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int lastOption;
        String str;
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());

            if (option == 1) {
                str = st.nextToken();
                deque.addLast(str);
                stack.push(option);
            } else if (option == 2) {
                str = st.nextToken();
                deque.addFirst(str);
                stack.push(option);
            } else if (option == 3) {
                if (deque.isEmpty()) continue;

                lastOption = stack.pop();
                if (lastOption == 1) deque.removeLast();
                else deque.removeFirst();
            }
        }

        if (deque.isEmpty()) {
            System.out.println(0);
        } else {
            for (String s : deque) {
                bw.write(s);
            }
            bw.flush();
        }
    }
}

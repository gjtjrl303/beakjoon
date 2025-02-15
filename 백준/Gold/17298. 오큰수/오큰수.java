import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] biggerIndex = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            numbers[i] = Integer.parseInt(s);
        }

        int max = numbers[0];

        for (int i = 0; i < n; i++) {
            if (stack.empty()) {
                stack.push(i);
            } else {
                while (!stack.empty() && numbers[stack.peek()] < numbers[i]) {
                    biggerIndex[stack.pop()] = numbers[i];
                }
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            biggerIndex[stack.pop()] = -1;
        }


        for (int index : biggerIndex) {
            bw.write(index + " ");
        }
        bw.flush();
    }
}

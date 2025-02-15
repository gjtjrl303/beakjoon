import java.io.*;
import java.util.HashMap;
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
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            int num = Integer.parseInt(s);
            if (map.containsKey(s)) {
                int updateValue = map.get(s) + 1;
                map.put(s, updateValue);
            }else{
                map.put(s, 1);
            }
            numbers[i] = num;
        }

        for (int i = 0; i < n; i++) {
            if (stack.empty()) {
                stack.push(i);
            } else {
                while((!stack.empty())
                        && (map.get(String.valueOf(numbers[i])) > map.get(String.valueOf(numbers[stack.peek()])))
                        &&(biggerIndex[stack.peek()] == 0)){
                    biggerIndex[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }

        while (!stack.empty()) {
            biggerIndex[stack.pop()] = -1;
        }

        for (int index : biggerIndex) {
            if (index == 0) {
                bw.write(0 + " ");
            } else {
                bw.write(index + " ");
            }
        }
        bw.flush();
    }
}

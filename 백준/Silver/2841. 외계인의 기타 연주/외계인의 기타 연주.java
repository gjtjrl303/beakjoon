
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Stack<Integer>> list = new ArrayList<>();

        int sum = 0;
        int N = scanner.nextInt();
        int P = scanner.nextInt();

        for (int i = 0; i <= 6; i++) {
            list.add(new Stack<>());
        }

        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();

            Stack<Integer> stack = list.get(n - 1);
            while (!stack.empty() && stack.peek() > p) {
                stack.pop();
                sum++;
            }
            if (!stack.empty() &&stack.peek() == p) continue;
            stack.push(p);
            sum++;
        }

        System.out.println(sum);
    }
}

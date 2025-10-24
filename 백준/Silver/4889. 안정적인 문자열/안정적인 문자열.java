
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String str;
        int index = 1;

        while (!(str = scanner.next()).startsWith("-")) {
            int sum = 0;

            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                if (c == '}') {
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(c);
            }

            while (!stack.empty()) {
                Character pop = stack.pop();
                if (pop == '{') {
                    stack.push('}');
                    sum++;
                } else if (pop == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else if (stack.peek() == '}') {
                        stack.pop();
                        sum++;
                    }
                }
            }
            System.out.println(index + ". " + sum);
            index++;
        }

    }
}

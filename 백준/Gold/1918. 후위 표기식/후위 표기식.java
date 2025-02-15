import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<Character> stack = new Stack<>();

        Map<Character, Integer> rank = new HashMap<>();
        rank.put('(', 0);
        rank.put(')', 0);
        rank.put('+', 1);
        rank.put('-', 1);
        rank.put('*', 2);
        rank.put('/', 2);

        for (int i = 0; i < str.length(); i++) {

            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                System.out.print(str.charAt(i));
            } else if (stack.empty()) {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    System.out.print(stack.pop());
                }
                stack.pop();
            } else if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            }else if (rank.get(str.charAt(i)) <= rank.get(stack.peek())) {
                while (!stack.empty() && rank.get(str.charAt(i)) <= rank.get(stack.peek())) {
                    System.out.print(stack.pop());
                }
                stack.push(str.charAt(i));
            }else if (str.length() > i + 1 && str.charAt(i + 1) == '(') {
                stack.push(str.charAt(i));
            } else {
                stack.push(str.charAt(i));
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}


import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] charArray = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {
            stack.push(charArray[i]);

            if (stack.size() >= 4) {
                char c1 = stack.pop();
                char c2 = stack.pop();
                char c3 = stack.pop();
                char c4 = stack.pop();

                if (c1 == 'P' && c2 == 'A' && c3 == 'P' && c4 == 'P') {
                    stack.push('P');
                } else {
                    stack.push(c4);
                    stack.push(c3);
                    stack.push(c2);
                    stack.push(c1);
                }
            }
        }

        if (stack.size() == 1) {
            if (stack.peek() == 'P') {
                System.out.println("PPAP");
                return;
            }
        }
        System.out.println("NP");
    }
}

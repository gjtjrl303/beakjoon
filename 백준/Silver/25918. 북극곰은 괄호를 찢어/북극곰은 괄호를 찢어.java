
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack();
        int N, S, maxCount = 0, count = 1;
        int maxSize= 0;
        boolean isContinue = false;

        N = scanner.nextInt();
        scanner.nextLine();
        char[] charArray = scanner.nextLine().toCharArray();

        for (char c : charArray) {
            if (stack.isEmpty()) {
                count = 1;
                stack.push(c);
                isContinue= false;
                continue;
            }

            if (c == '(') {
                if (stack.peek() == ')') {
                    maxSize = Math.max(maxSize,stack.size());
                    stack.pop();
                    if (isContinue) {
                        count++;
                    } else {
                        isContinue = true;
                    }
                } else {
                    stack.push(c);
                    isContinue = false;
                }
            } else if (c == ')') {
                if (stack.peek() == '(') {
                    maxSize = Math.max(maxSize,stack.size());
                    stack.pop();
                    if (isContinue) {
                        count++;
                    } else {
                        isContinue =true;
                    }
                } else {
                    stack.push(c);
                    isContinue = false;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        if(stack.isEmpty()) System.out.println(maxSize);
        else System.out.println(-1);
    }
}

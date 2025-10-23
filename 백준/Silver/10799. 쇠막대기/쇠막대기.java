
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        Stack<Character> stack = new Stack<>();

        String str = scanner.next();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(charArray[i]);
            } else {
                if (i -1 >=0 && charArray[i-1] == '(' ) {
                    stack.pop();
                    sum += stack.size();
                } else {
                    stack.pop();
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}

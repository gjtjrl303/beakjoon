
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        int size = 0;

        Scanner scanner = new Scanner(System.in);
        char[] array = scanner.next().toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(array[i]);
            } else if (array[i] == ')') {
                stack.pop();
            } else {
                size = stack.size();
            }
        }

        System.out.println(size);
    }
}

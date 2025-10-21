
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int command = scanner.nextInt();
            if (command == 1) {
                myStack.push(scanner.nextInt());
            } else if (command == 2) {
                myStack.pop();
            } else if (command == 3) {
                myStack.cancel(scanner.nextInt());
            } else if (command == 4) {
                myStack.getSize();
            } else if (command == 5) {
                myStack.printPeek();
            }
        }
    }
}

class MyStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> rollback = new Stack<>();

    public void push(int number) {
        rollback.push(number);
        stack.push(number);
    }

    public void pop() {
        rollback.push(-stack.pop());
    }

    public void cancel(int number) {
        for (int i = 0; i < number; i++) {
            int last = rollback.pop();
            if (last >= 1) stack.pop();
            else stack.push(-last);
        }
    }

    public void getSize() {
        System.out.println(stack.size());
    }

    public void printPeek() {
        if (stack.empty()) System.out.println(-1);
        else System.out.println(stack.peek());
    }
}

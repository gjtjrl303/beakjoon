
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> answer = new LinkedList<>();
        List<Character> cList = new ArrayList<>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            answer.add(scanner.nextInt());
        }

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            cList.add('+');
            while (!answer.isEmpty() && !stack.empty() && answer.peek().equals(stack.peek())) {
                answer.remove();
                stack.pop();
                cList.add('-');
            }
        }

        if (!answer.isEmpty()) {
            System.out.println("NO");
        } else {
            for (Character c : cList) {
                System.out.println(c + " ");
            }
        }


    }
}

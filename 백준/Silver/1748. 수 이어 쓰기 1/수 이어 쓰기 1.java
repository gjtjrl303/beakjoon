
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int count = 0, length;
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        length = String.valueOf(N).length();

        int temp = 1;
        int index = 1;
        for (int i = 0; i < length - 1; i++) {
            count += temp * 9 * index++;
            temp *= 10;
        }

        count += (N - temp + 1) * length;
        System.out.println(count);
    }

}

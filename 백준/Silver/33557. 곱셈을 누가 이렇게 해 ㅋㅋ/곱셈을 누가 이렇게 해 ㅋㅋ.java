
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            StringBuilder A = new StringBuilder(scanner.next()).reverse();
            StringBuilder B = new StringBuilder(scanner.next()).reverse();
            StringBuilder sb = new StringBuilder();

            int indexA = 0, indexB = 0;

            while (indexA < A.length() && indexB < B.length()) {
                sb.insert(0,(A.charAt(indexA) - '0') * (B.charAt(indexB) - '0'));
                indexA++;
                indexB++;
            }

            while (indexA < A.length()) {
                sb.insert(0,A.charAt(indexA));
                indexA++;
            }

            while (indexB < B.length()) {
                sb.insert(0,B.charAt(indexB));
                indexB++;
            }

            if (Long.valueOf(A.reverse().toString()) * Long.valueOf(B.reverse().toString()) == Long.valueOf(sb.toString())) System.out.println(1);
            else System.out.println(0);
        }
    }
}


import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < 200000000; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length() - 2; j++) {
                if (s.charAt(j) == '6' && s.charAt(j + 1) == '6' && s.charAt(j + 2) == '6') {
                    count++;
                    if (count == N) {
                        System.out.println(s);
                        return;
                    }
                    break;
                }
            }
        }
    }
}

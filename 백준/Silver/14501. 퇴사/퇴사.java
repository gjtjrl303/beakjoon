
import java.util.Scanner;

public class Main {

    static int N;
    static int[] dayArr;
    static int[] moneyArr;
    static int sum = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dayArr = new int[N];
        moneyArr = new int[N];

        for (int i = 0; i < N; i++) {
            dayArr[i] = scanner.nextInt();
            moneyArr[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; ) {
            int money = 0;
            if (i + dayArr[i] <= N) {
                int j = i + dayArr[i];
                recursion(j, money + moneyArr[i]);
            }
            i++;
            recursion(i, money);
        }
        System.out.println(sum);
    }


    private static void recursion(int i, int money) {
        if (i >= N) {
            if (sum < money) {
                sum = money;
            }
            return;
        }

        for (int j = i; j < N; ) {
            if (j + dayArr[j] <= N) {
                int k = j + dayArr[j];
                recursion(k, money + moneyArr[j]);
            }
            j++;
            recursion(j, money);
        }
    }
}


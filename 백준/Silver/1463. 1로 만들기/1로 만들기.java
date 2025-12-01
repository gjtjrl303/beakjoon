import java.util.Scanner;

public class Main {

    public static int MAX = 1000001;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int[] count = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            count[i] = MAX;
        }

        count[1] = 0;
        for (int i = 1; i < MAX; i++) {
            if (i - 1 >= 1) {
                if (count[i] > count[i - 1] + 1) {
                    count[i] = count[i - 1] + 1;
                }
            }

            if (i / 2 >= 1 && i % 2 == 0) {
                if (count[i] > count[i / 2] + 1) {
                    count[i] = count[i / 2] + 1;
                }
            }

            if (i / 3 >= 1 && i % 3 == 0) {
                if (count[i] > count[i / 3] + 1) {
                    count[i] = count[i / 3] + 1;
                }
            }
        }

        System.out.println(count[X]);

//        int count = 0;
//
//        while (X != 1) {
//            if (X % 3 == 0) {
//                X /= 3;
//                count++;
//            } else if ((X - 1) % 3 == 0) {
//                X--;
//                X /= 3;
//                count += 2;
//            } else if ((X % 2 == 0)) {
//                X /= 2;
//                count++;
//            } else {
//                X-=2;
//                X /= 3;
//                count+=3;
//            }
//        }
    }
}

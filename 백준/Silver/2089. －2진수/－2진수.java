
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        int[] array = new int[100000];
        int index = 0;


        while (i != 0) {
            int temp = i % -2;
            if (temp == 0) {
                temp = 0;
            } else if (temp == 1) {
                temp = 1;
            } else {
                temp = 1;
                i -= 1;
            }
            array[index++] = temp;
            i /= -2;
        }

        if (index == 0) {
            index++;
        }

        for (int j = index - 1; j >= 0; j--) {
            System.out.print(array[j]);
        }
    }
}


import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Main {

    static char[][] matrix;
    static int count = 0;
    static int[] output;
    static int n;
    static boolean isFind = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        matrix = new char[n][n];
        output = new int[n];


        int index = 0;
        String string = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                matrix[i][j] = string.charAt(index++);
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[i][i] == '+') {
                for (int j = 1; j <= 10; j++) {
                    output[count] = j;
                    if(!checkOutput()) continue;
                    count++;
                    dfs();
                    if(isFind) return;
                    count--;
                }
            } else if (matrix[i][i] == '-') {
                for (int j = -1; j >= -10; j--) {
                    output[count] = j;
                    if(!checkOutput()) continue;
                    count++;
                    dfs();
                    if(isFind) return;
                    count--;
                }
            } else {
                output[count] = 0;
                if(!checkOutput()) continue;
                count++;
                dfs();
                if(isFind) return;
                count--;
            }

        }
    }

    static void dfs() {
        if (count == n) {
             if (checkOutput()) {
                for (int i = 0; i < n; i++) {
                    System.out.print(output[i] + " ");
                }
                isFind = true;
            }
            return;
        }

        if (matrix[count][count] == '+') {
            for (int j = 1; j <= 10; j++) {
                output[count] = j;
                if(!checkOutput()) continue;
                count++;
                dfs();
                if (isFind) return;
                count--;
            }
        } else if (matrix[count][count] == '-') {
            for (int j = -1; j >= -10; j--) {
                output[count] = j;
                if(!checkOutput()) continue;
                count++;
                dfs();
                if (isFind) return;
                count--;
            }
        } else {
            output[count] = 0;
            if(!checkOutput()) return;
            count++;
            dfs();
            if (isFind) return;
            count--;
        }

    }

    private static boolean checkOutput() {

//        for (int i = 0; i < count; i++) {
//            System.out.print(output[i] + " ");
//        }
//        System.out.println();

        for (int i = 0; i < count; i++) {
            int sum = 0;
            sum += output[i];
            for (int j = i + 1; j < count; j++) {
                sum += output[j];
                if (sum > 0 && matrix[i][j] == '+') {

                } else if (sum < 0 && matrix[i][j] == '-') {

                } else if (sum == 0 && matrix[i][j] == '0') {

                } else
                    return false;
            }
        }
        return true;
    }
}

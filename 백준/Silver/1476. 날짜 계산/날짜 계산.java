
import java.util.Scanner;

public class Main {

    public static int maxE = 15;
    public static int maxS = 28;
    public static int maxM = 19;

    public static void main(String[] args) {

        int E, S, M;
        int indexE = 0, indexS = 0, indexM = 0;

        Scanner scanner = new Scanner(System.in);
        E = scanner.nextInt();
        S = scanner.nextInt();
        M = scanner.nextInt();

        int year = 0;
        while (E != indexE || S != indexS || M != indexM) {
            year++;
            indexE = indexE % maxE + 1;
            indexS = indexS % maxS + 1;
            indexM = indexM % maxM + 1;
        }

        System.out.println(year);

    }
}

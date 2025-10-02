
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int N = scanner.nextInt();

        int[][] bomber = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = scanner.next();
            int index = 0;
                for (char c :str.toCharArray()) {
                    if(c == '.') bomber[i][index++] = 0;
                    else bomber[i][index++] = 2;
            }
        }
//
//        System.out.println("================ 초기값 =========================");
//
//        for (int j = 0; j < R; j++) {
//            for (int k = 0; k < C; k++) {
//                System.out.print(bomber[j][k] +" ");
//            }
//            System.out.println();
//        }


        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (bomber[j][k] != 0) {
                        bomber[j][k]++;
                    } else{
                        if (i% 2 == 0  && bomber[j][k] == 0) {
                            bomber[j][k] = 1;
                        }
                    }
                }
            }

            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (bomber[j][k] == 4) {
                        if (j > 0 && bomber[j-1][k] !=4) {
                            bomber[j - 1][k] = 0;
                        }
                        if (k > 0 && bomber[j][k-1] !=4) {
                            bomber[j][k-1] = 0;
                        }
                        if(j <R -1&& bomber[j+1][k] !=4){
                            bomber[j+1][k] = 0;
                        }
                        if(k <C - 1&& bomber[j][k+1] !=4){
                            bomber[j][k+1] = 0;
                        }
                        bomber[j][k] = 0;
                    }
                }
            }

//            System.out.println(" ========================= 폭발 ==================================");
//
//            for (int j = 0; j < R; j++) {
//                for (int k = 0; k < C; k++) {
//                    System.out.print(bomber[j][k]+ " ");
////                    if (bomber[j][k] != 0) {
////                        System.out.print("O ");
////                    }else System.out.print(". ");
//                }
//                System.out.println();
//            }
        }

//        System.out.println("============================= 결과 +==========================");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomber[i][j] <= 0) {
                    System.out.print(".");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }
}

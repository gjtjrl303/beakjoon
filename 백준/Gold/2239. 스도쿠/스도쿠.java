
import java.util.Scanner;

public class Main {

    public static int[][] sudoku = new int[10][10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            char[] charArray = scanner.next().toCharArray();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }

        dfs(0, 0, sudoku);
    }

    public static void dfs(int i, int j, int[][] sudoku) {
        if (i == 8 && j == 9) {
            checkSudoku(sudoku);
        } else if (j == 9) {
            i++;
            j = 0;
        }
        if (sudoku[i][j] != 0) {
            dfs(i, j + 1, sudoku);
            return;
        }

        for (int checkNum = 1; checkNum <= 9; checkNum++) {
            if (checkBox(i, j, checkNum) && checkRow(i, checkNum) && checkColumn(j, checkNum)) {
                sudoku[i][j] = checkNum;
                dfs(i, j + 1, sudoku);
                sudoku[i][j] = 0;
            }
        }
    }

    private static boolean checkSudoku(int[][] sudoku) {
        int count = 0;
        for (int k = 0; k < 9; k++) {
            for (int l = 0; l < 9; l++) {
                if (sudoku[k][l] == 0) count++;
            }
        }
        if (count == 0) {
            printSudoku(sudoku);
            System.exit(0);
        }
        return false;
    }

    private static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean checkBox(int row, int column, int checkNum) {
        int checkRow = row / 3;
        int checkColumn = column / 3;

        for (int i = checkRow * 3; i < checkRow * 3 + 3; i++) {
            for (int j = checkColumn * 3; j < checkColumn * 3 + 3; j++) {
                if (sudoku[i][j] == checkNum) return false;
            }
        }
        return true;
    }

    private static boolean checkRow(int row, int checkNum) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == checkNum) return false;
        }
        return true;
    }

    private static boolean checkColumn(int column, int checkNum) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][column] == checkNum) return false;
        }
        return true;
    }
}

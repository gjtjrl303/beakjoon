import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] height = new int[9];
        for (int i = 0; i < 9; i++) {
            height[i] = scanner.nextInt();
        }
        List<Integer> list = new ArrayList<>();

        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {

                int sum = 0;
                for (int k = 0; k < 9; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    sum += height[k];
                    list.add(height[k]);
                }
                if (sum == 100) {
                    flag = true;
                    break;
                }
                list.clear();
            }
            if (flag) {
                break;
            }
        }

        Collections.sort(list);

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}


import com.sun.source.tree.Tree;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(String.valueOf(br.readLine()));
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(String.valueOf(br.readLine()));
        }

        Arrays.sort(numbers);
        for (int number : numbers) {
            bw.write(number + "\n");
        }
        bw.flush();
    }

}

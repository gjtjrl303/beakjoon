
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        TreeSet<Integer> integers = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =  Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            integers.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < N; i++) {
            bw.write(integers.first() + "\n");
            integers.pollFirst();
        }

        bw.flush();
    }
}

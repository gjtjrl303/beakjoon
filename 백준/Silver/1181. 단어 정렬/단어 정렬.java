
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        HashSet<String> set = new LinkedHashSet<>();
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            set.add(scanner.next());
        }
        List<String> list = new LinkedList<>(set);

        list.sort((s1, s2) -> {
            String str1 = (String) s1;
            String str2 = (String) s2;

            if (str1.length() == str2.length()) return str1.compareTo(str2);
            else return str1.length() - str2.length();
        });

        for (String s : list) {
            bw.write(s + "\n");
        }

        bw.flush();

    }
}

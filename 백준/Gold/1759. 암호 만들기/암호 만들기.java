
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[] aeiou = {'a', 'e', 'i', 'o', 'u'};
    static char[] array;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L, C;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        array = br.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(array[i]));
            recursion(i, sb, count + 1);
        }
        bw.flush();
    }

    private static void recursion(int i, StringBuilder sb, int count) throws IOException {
        if (count == L) {
            int matchCount = 0;
            int elseCount = 0;
            for (int j = 0; j < L; j++) {
                boolean flag = false;
                for (int k = 0; k < 5; k++) {
                    if (sb.charAt(j) == aeiou[k]) {
                        matchCount++;
                        flag = true;
                    }
                }
                if (!flag) {
                    elseCount++;
                }
            }
            if (matchCount >= 1 && elseCount >= 2) {
                bw.write(sb + "\n");
            }
            return;
        }

        for (int j = i + 1; j < C; j++) {
            StringBuilder newSb = new StringBuilder(sb);
            newSb.append(array[j]);
            recursion(j, newSb, count + 1);
        }
    }
}




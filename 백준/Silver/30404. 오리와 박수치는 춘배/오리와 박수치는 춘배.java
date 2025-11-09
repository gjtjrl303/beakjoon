
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        boolean[] isDuck = new boolean[1_000_001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            isDuck[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < 1000000; i++) {
            if(isDuck[i]){
                count++;
                i += K;
            }
        }
        System.out.println(count);
    }
}


import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Set<Xy> set = new TreeSet<>();


    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Xy xy = new Xy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            set.add(xy);

        }
        for (Xy xy : set) {
            System.out.println(xy.x + " " + xy.y);
        }
    }


    static class Xy implements Comparable {
        int x;
        int y;

        public Xy(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Xy other = (Xy) o;
            if (other.x > x) {
                return -1;
            } else if (other.x == x) {
                if (other.y > y) {
                    return -1;
                }
            }
            return 1;
        }
    }
}

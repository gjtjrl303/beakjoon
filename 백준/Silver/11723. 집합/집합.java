
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean[] num = new boolean[22];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String option = st.nextToken();

            if (option.equals("add")) {
                num[Integer.parseInt(st.nextToken())] = true;
            } else if (option.equals("remove")) {
                num[Integer.parseInt(st.nextToken())] = false;
            } else if (option.equals("check")) {
                if (num[Integer.parseInt(st.nextToken())]){
                    bw.write(1 + "\n");
                } else{
                    bw.write(0 + "\n");

                }
            } else if (option.equals("toggle")) {
                String temp = st.nextToken();
                if (num[Integer.parseInt(temp)]) {
                    num[Integer.parseInt(temp)] = false;
                } else {
                    num[Integer.parseInt(temp)] = true;
                }
            } else if (option.equals("all")) {
                for (int j = 1; j <= 21; j++) {
                    num[j] = true;
                }
            } else if (option.equals("empty")) {
                for (int j = 1; j <= 21; j++) {
                    num[j] = false;
                }
            }

        }
        bw.flush();
    }
}



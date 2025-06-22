
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean[] isBroken = new boolean[10];
        boolean[] isAvailable = new boolean[1000000];
        int targetChannel, closestChannelNumber = -1, numLength = 1, count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        targetChannel = Integer.parseInt(br.readLine());
        int brokenNum = Integer.parseInt(br.readLine());
        if (brokenNum != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreElements()) {
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for (int i = 0; i < 1000000; i++) {
            if (i == 0) {
                isAvailable[i] = !isBroken[0];
                continue;
            }
            isAvailable[i] = validate(isBroken, i);
        }

        for (int i = 0; i <= Math.abs(targetChannel - 100); i++) {
            if (targetChannel - i >= 0 && isAvailable[targetChannel - i]) {
                closestChannelNumber = targetChannel - i;
                break;
            } else {
                if (isAvailable[targetChannel + i]) {
                    closestChannelNumber = targetChannel + i;
                    break;
                }
            }
        }

        if (targetChannel == 100) {
            bw.write(String.valueOf(count));
            bw.flush();
            return;
        }

        if(closestChannelNumber == -1){
            closestChannelNumber = 100;
        }

        int temp = closestChannelNumber;
        temp /= 10;
        while (temp > 0) {
            numLength++;
            temp /= 10;
        }
        count = Math.abs(targetChannel - closestChannelNumber);
        count += numLength;

        int temp2 = Math.abs(targetChannel - 100);
        count = Math.min(temp2, count);

        bw.write(String.valueOf(count));
        bw.flush();

    }

    private static boolean validate(boolean[] isBroken, int channelNumber) {
        while (channelNumber > 0) {
            if (isBroken[channelNumber % 10]) {
                return false;
            }
            channelNumber /= 10;
        }
        return true;
    }
}

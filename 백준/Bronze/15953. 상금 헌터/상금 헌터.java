import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int total = 0;
            if (a != 0) {
                if (a <= 1) total += 5000000;
                else if (a <= 3) total += 3000000;
                else if (a <= 6) total += 2000000;
                else if (a <= 10) total += 500000;
                else if (a <= 15) total += 300000;
                else if (a <= 21) total += 100000;
            }
            if (b != 0) {
                if (b <= 1) total += 5120000;
                else if (b <= 3) total += 2560000;
                else if (b <= 7) total += 1280000;
                else if (b <= 15) total += 640000;
                else if (b <= 31) total += 320000;
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);

    }
}

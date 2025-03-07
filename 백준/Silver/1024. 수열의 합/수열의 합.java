import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();
        long N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        boolean flag = false;
        for (int n = L; n <= 100; n++) {
            long cur = (2 * N - n * (n - 1)) / (2 * n);

            if ((2 * N - n * (n - 1)) % (2 * n) == 0) {
                if (cur >= 0) {
                    for (long i = cur; n > 0; i++) {
                        sb.append(i).append(" ");
                        n--;
                    }
                    flag = true;
                    break;
                }
            }
        }

        if (flag) System.out.println(sb);
        else System.out.println(-1);

    }
}

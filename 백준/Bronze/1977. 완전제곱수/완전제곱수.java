import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int res = 0;
        int min = N + 1;
        for (int i = M; i <= N; i++) {
            String s = String.valueOf(Math.sqrt(i));
            if (s.endsWith(".0")) {
                res += i;
                min = Math.min(min, i);
            }
        }
        if (res == 0) System.out.println(-1);
        else {
            System.out.println(res);
            System.out.println(min);
        }
    }
}

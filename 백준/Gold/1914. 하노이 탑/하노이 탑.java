import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb.append(new BigInteger("2").pow(N).subtract(new BigInteger("1"))).append("\n");

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
        }

        System.out.println(sb);
    }

    private static void hanoi(int n, int a, int b, int c) {
        if (n == 1) {
            sb.append(a).append(" ").append(c).append("\n");
            return;
        }
        hanoi(n - 1, a, c, b);
        hanoi(1, a, b, c);
        hanoi(n - 1, b, a, c);
    }
}

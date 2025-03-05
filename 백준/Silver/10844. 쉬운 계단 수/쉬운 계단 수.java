import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(9);
        } else {

            int[][] dp  = new int[N+1][10];
            Arrays.fill(dp[1],1,10,1);

            for (int i = 2; i <= N; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (j-1 >= 0) dp[i][j] += dp[i-1][j-1];
                    if (j+1 <= 9) dp[i][j] += dp[i-1][j+1];
                    dp[i][j] %= 1000000000;
                }
            }

            int sum = 0;
            for (int i = 0; i <= 9; i++) {
                sum = (sum + dp[N][i]) % 1000000000;
            }
            System.out.println(sum);

        }
    }
}

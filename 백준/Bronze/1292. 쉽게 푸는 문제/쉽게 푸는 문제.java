import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] dp = new int[B+1];

        int num = 1;
        for (int i = 1; i <= B; i++) {
            int index = i;
            for (int j = index; j < index + num; j++) {
                if (j > B) break;
                dp[j] = num;
            }
            i = index + num - 1;
            num++;
        }

        int sum = 0;
        for (int i = A; i <= B; i++) {
            sum += dp[i];
        }
        System.out.println(sum);
    }
}

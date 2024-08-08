import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] quality = new int[N];
        for (int i = 0; i < N; i++) {
            quality[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(quality);
        int res = 0;
        for (int i = N/2; i < N; i++) {
            res += quality[i] * 2;
        }
        if (N % 2 != 0) {
            res -= quality[N/2];
        }

        System.out.println(res);
    }
}

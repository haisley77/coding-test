import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] height = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        for (int h : height) {
            if (h > right) {
                right = h;
            }
        }

        int res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (height[i] > mid) {
                    sum += height[i] - mid;
                }
            }

            if (sum >= M) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }
}

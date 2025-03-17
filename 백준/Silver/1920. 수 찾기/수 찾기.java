import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++){
            long num =  Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N-1;

            boolean flag = false;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (A[mid] == num) {
                    sb.append(1).append("\n");
                    flag = true;
                    break;
                } else if (A[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (!flag) sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}

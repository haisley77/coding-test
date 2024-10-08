import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] graph = new int[N+1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());
                graph[s1] = s2;
            }
            int standard = graph[1];
            int total = 1;
            for (int j = 2; j <= N; j++) {
                int cur = graph[j];
                if (cur < standard) {
                    total++;
                    standard = cur;
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }

}

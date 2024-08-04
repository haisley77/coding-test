import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K-1; j++) {
                q.offer(q.poll());
            }
            if (i == N-1) sb.append(q.poll()).append(">");
            else sb.append(q.poll()).append(", ");
        }
        System.out.println(sb);
    }
}

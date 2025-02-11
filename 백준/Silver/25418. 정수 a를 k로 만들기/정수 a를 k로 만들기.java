import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[K+1];

        Queue<Integer> q = new LinkedList<>();
        visited[K] = 1;
        q.offer(K);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == A) {
                System.out.println(visited[cur]-1);
                break;
            }

            // 정수 A에 1을 더한다
            if (cur-1 >= A) {
                if (visited[cur-1] != 0) continue;
                visited[cur-1] = visited[cur] + 1;
                q.offer(cur-1);
            }
            // 정수 A에 2를 곱한다
            if (cur%2 == 0 && cur/2 >= A) {
                if (visited[cur/2] != 0) continue;
                visited[cur/2] = visited[cur] + 1;
                q.offer(cur/2);
            }

        }

    }

}

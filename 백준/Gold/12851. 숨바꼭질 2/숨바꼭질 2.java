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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int res = 0;

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        // x-1
        // x+1
        // x*2

        int[] visited = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) res++;

            if (cur - 1 >= 0) {
                if (visited[cur - 1] > 0) {
                    if (visited[cur] + 1 == visited[cur-1]) { // 같은 너비
                        q.offer(cur-1);
                    }
                } else {
                    visited[cur-1] = visited[cur] + 1;
                    q.offer(cur-1);
                }
            }
            if (cur + 1 <= 100000) {
                if (visited[cur+1] > 0) {
                    if (visited[cur] + 1 == visited[cur+1]) { // 같은 너비
                        q.offer(cur+1);
                    }
                } else {
                    visited[cur+1] = visited[cur] + 1;
                    q.offer(cur+1);
                }
            }
            if (cur * 2 <= 100000) {
                if (visited[cur*2] > 0) {
                    if (visited[cur] + 1 == visited[cur*2]) { // 같은 너비
                        q.offer(cur*2);
                    }
                } else {
                    visited[cur*2] = visited[cur] + 1;
                    q.offer(cur*2);
                }
            }
        }

        System.out.println(visited[K]-1);
        System.out.println(res);

    }
}

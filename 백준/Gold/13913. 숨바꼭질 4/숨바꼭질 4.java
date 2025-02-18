import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        int[] prev = new int[100001];
        Queue<Integer> q = new LinkedList<>();

        visited[N] = 1;
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    prev[next] = cur;
                    q.offer(next);

                    if (next == K) break;

                }
            }
        }

        System.out.println(visited[K] - 1);

        // 경로 역추적
        List<Integer> path = new ArrayList<>();
        for (int i = K; i != N; i = prev[i]) {
            path.add(i);
        }
        path.add(N);


        StringBuilder sb = new StringBuilder();
        for (int i = path.size()-1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}

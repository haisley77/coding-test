import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int v;
        Node next;
        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }
    private static StringBuilder sb = new StringBuilder();
    private static Node[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new Node[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a] = new Node(b, graph[a]);
            graph[b] = new Node(a, graph[b]);
        }


        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[N+1];
        visited[1] = 1;
        q.offer(1);

        int max = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Node node = graph[cur]; node != null; node = node.next) {
                if (visited[node.v] > 0) continue;
                visited[node.v] = visited[cur] + 1;
                max = visited[node.v];
                q.offer(node.v);
            }
        }

        int minIdx = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (max == visited[i]) {
                if (cnt == 0) {
                    sb.append(i).append(" ").append(max-1).append(" ");
                }
                cnt++;
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}

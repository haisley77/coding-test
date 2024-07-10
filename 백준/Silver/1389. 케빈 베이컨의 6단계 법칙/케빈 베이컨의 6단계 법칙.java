import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int v;
        Node next;
        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }
    static Node[] graph;
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

        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                sum += bfs(i,j,N);
            }
            if (min > sum) {
                min = sum;
                res = i;
            };
        }
        System.out.println(res);

    }

    private static int bfs(int start, int end, int N){
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[N+1];
        visited[start] = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) break;

            for (Node node = graph[cur]; node != null; node = node.next) {
                if (visited[node.v] != 0) continue;
                visited[node.v] = visited[cur] + 1;
                q.offer(node.v);
            }
        }
        return visited[end] - 1;
    }
}

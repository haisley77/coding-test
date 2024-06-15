import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static boolean[] visited;
    private static Node[] graph;
    private static StringBuilder sb = new StringBuilder();
    private static class Node{
        int v;
        Node next;
        Node(int v, Node next){
            this.v = v;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            graph = new Node[N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a] = new Node(b,graph[a]);
                graph[b] = new Node(a,graph[b]);
            }
            sb.append(dfs(1, 0)).append("\n");
        }
        System.out.print(sb);
    }

    public static int dfs(int cur, int cnt) {
        visited[cur] = true;
        for (Node node = graph[cur]; node != null; node = node.next) {
            if (visited[node.v]) continue;
            cnt = dfs(node.v, cnt+1);
        }
        return cnt;
    }
}

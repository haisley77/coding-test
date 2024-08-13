import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int v;
        Edge next;
        Edge(int v, Edge next) {
            this.v = v;
            this.next = next;
        }

    }
    static int N;
    static Edge[] graph;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        graph = new Edge[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u] = new Edge(v, graph[u]);
            graph[v] = new Edge(u, graph[v]);
        }
        int root = 1;
        dfs(root);

        System.out.println(Math.min(dp[root][0],dp[root][1]));
    }

    private static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = 1;

        for (Edge edge = graph[node]; edge != null; edge = edge.next) {
            if (visited[edge.v]) continue;
            dfs(edge.v);
            dp[node][0] += dp[edge.v][1];
            dp[node][1] += Math.min(dp[edge.v][0], dp[edge.v][1]);
        }
    }



}

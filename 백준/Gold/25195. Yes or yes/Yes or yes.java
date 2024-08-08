import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int v;
        boolean flag;
        Node(int v, boolean flag) {
            this.v = v;
            this.flag = flag;
        }
    }
    static class Edge {
        int v;
        Edge next;
        Edge(int v, Edge next) {
            this.v = v;
            this.next = next;
        }
    }
    static Edge[] graph;
    static boolean[] fan;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new Edge[N+1];
        fan = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u] = new Edge(v, graph[u]);
        }

        int S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int s = Integer.parseInt(st.nextToken());
            fan[s] = true;
        }
        
        bfs();
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        if (fan[1]) {
            visited[1] = true;
            q.offer(new Node(1,true));
        } else {
            visited[1] = true;
            q.offer(new Node(1,false));
        }

        boolean meet = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            int cnt = 0;
            for (Edge edge = graph[cur.v]; edge != null; edge = edge.next) {
                cnt++;
                if (visited[edge.v]) continue;
                if (!cur.flag && !fan[edge.v]) {
                    visited[edge.v] = true;
                    q.offer(new Node(edge.v, false));
                }
            }
            if (cnt == 0 && !cur.flag) {
                meet = false;
                break;
            }

        }
        if (!meet) System.out.println("yes");
        else System.out.println("Yes");

    }
}
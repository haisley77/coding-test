import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Vertex {
        int v;
        int t;
        Vertex next;
        Vertex(int v, int t, Vertex next) {
            this.v = v;
            this.t = t;
            this.next = next;
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int curTime;
        Node(int v, int curTime) {
            this.v = v;
            this.curTime = curTime;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.curTime, node.curTime);
        }
    }

    static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Vertex[] graph = new Vertex[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[a] = new Vertex(b,t,graph[a]);
        }

        int[] ret = dijkstra(X, graph);
        int[] turnAroundTime = new int[N+1];
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            int[] temp = dijkstra(i, graph);
            turnAroundTime[i] = temp[X] + ret[i];
            if (res < turnAroundTime[i]) res = turnAroundTime[i];
        }
        System.out.println(res);
    }

    private static int[] dijkstra(int s, Vertex[] graph) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[s] = 0;
        pq.offer(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Vertex vertex = graph[cur.v]; vertex != null; vertex = vertex.next) {
                if (cost[vertex.v] > cur.curTime + vertex.t) {
                    cost[vertex.v] = cur.curTime + vertex.t;
                    pq.offer(new Node(vertex.v, cost[vertex.v]));
                }
            }
        }

        return cost;

    }
}

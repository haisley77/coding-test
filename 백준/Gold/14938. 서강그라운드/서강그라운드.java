import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int v;
        int l;
        Edge next;
        Edge(int v, int l, Edge next) {
            this.v = v;
            this.l = l;
            this.next = next;
        }
    }

    static class Node implements Comparable<Node>{
        int v;
        int cost;
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.cost, node.cost);
        }
    }
    static int[] item;
    static int n,m,r;
    static Edge[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        graph = new Edge[n+1];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[a] = new Edge(b,l,graph[a]);
            graph[b] = new Edge(a,l,graph[b]);
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = dijkstra(i);
            if (cnt > res) {
                res = cnt;
            }
        }
        
        System.out.println(res);
        
    }

    private static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Edge edge = graph[cur.v]; edge != null; edge = edge.next) {
                if (dist[edge.v] > cur.cost + edge.l) {
                    dist[edge.v] = cur.cost + edge.l;
                    pq.offer(new Node(edge.v, dist[edge.v]));
                }
            }
        }
        

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > m) continue;
            cnt += item[i];
        }

        return cnt;

    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int v;
        Long s;
        Node next;
        Node(int v, Long s, Node next) {
            this.v = v;
            this.s = s;
            this.next = next;
        }
    }
    static class Edge implements Comparable<Edge> {
        int v;
        Long dist;
        Edge(int v, Long dist) {
            this.v = v;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge e) {
            return Long.compare(this.dist, e.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Node[] graph = new Node[n+1];
            Long[] dist = new Long[n+1];
            Arrays.fill(dist, Long.MAX_VALUE);
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                Long s = Long.parseLong(st.nextToken());
                graph[b] = new Node(a, s, graph[b]);
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            dist[c] = 0L;
            pq.offer(new Edge(c,dist[c]));

            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                for (Node node = graph[edge.v]; node != null; node = node.next) {
                    if (dist[node.v] > edge.dist + node.s) {
                        dist[node.v] = edge.dist + node.s;
                        pq.offer(new Edge(node.v, dist[node.v]));
                    }
                }
            }

            int cnt = 0;
            Long time = Long.MIN_VALUE;

            for (int i = 1; i <= n; i++) {
                if (dist[i] == Long.MAX_VALUE) continue;
                cnt++;
                if (time < dist[i]) time = dist[i];
            }
            sb.append(cnt).append(" ").append(time).append("\n");
        }

        System.out.println(sb);

    }
}

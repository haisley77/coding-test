import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int v;
        int c;
        Node next;
        Node(int v, int c, Node next) {
            this.v = v;
            this.c = c;
            this.next = next;
        }
    }

    static class Edge implements Comparable<Edge> {
        int v;
        int c;
        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.c, e.c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node[] graph = new Node[N+1];
        int[] cost = new int[N+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Arrays.fill(cost,Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a] = new Node(b,c,graph[a]);
            graph[b] = new Node(a,c,graph[b]);
        }

        cost[1] = 0;
        pq.offer(new Edge(1,0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            for (Node node = graph[cur.v]; node != null; node = node.next) {
                if (cost[node.v] > cur.c + node.c) {
                    cost[node.v] = cur.c + node.c;
                    pq.offer(new Edge(node.v, cost[node.v]));
                }
            }
        }

        System.out.println(cost[N]);

    }
}

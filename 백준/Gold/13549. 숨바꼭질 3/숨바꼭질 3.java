import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[] distance;
    static class Node implements Comparable<Node> {
        int v;
        int t;
        Node(int node, int t) {
            this.v = node;
            this.t = t;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.t, node.t);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dijkstra(N, K);
        System.out.println(distance[K]);
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance = new int[200001];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int v = curr.v;
            int t = curr.t;

            if (distance[v] < t) continue;

            // x-1
            if (v-1 >= 0 && t + 1 < distance[v-1]) {
                distance[v-1] = t + 1;
                pq.offer(new Node(v-1, distance[v-1]));
            }
            // x+1
            if (v+1 < distance.length && t + 1 < distance[v+1]) {
                distance[v+1] = t + 1;
                pq.offer(new Node(v+1, distance[v+1]));
            }
            // x*2
            if (v*2 < distance.length && t < distance[v*2]) {
                distance[v*2] = t;
                pq.offer(new Node(v*2, distance[v*2]));
            }
        }
    }
}

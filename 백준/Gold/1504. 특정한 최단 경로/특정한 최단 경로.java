import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, E, v1, v2, res1, res2;
    static final int INF = Integer.MAX_VALUE;
    static class Node implements Comparable<Node> {
        int v;
        int w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static int[][] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph= new int[N+1][N+1];
        dist = new int[N+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = c;
        }
        st = new StringTokenizer(br.readLine()," ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        // 1- > v1 -> v2 -> N
        Arrays.fill(dist, INF);
        int tempA = dijkstra(1, v1);
//        System.out.println(1 + " " +v1 +  " 비용 : " + tempA);
        Arrays.fill(dist, INF);
        int tempB = dijkstra(v1,v2);
//        System.out.println(v1 + " " +v2 +  " 비용 : " + tempB);
        Arrays.fill(dist, INF);
        int tempC = dijkstra(v2,N);
//        System.out.println(v2 + " " +N +  " 비용 : " + tempC);

        if  (tempA == INF || tempB == INF || tempC == INF) res1 = -1;
        else res1 = tempA + tempB + tempC;


        // 1 -> v2 -> v1 -> N
        Arrays.fill(dist, INF);
        tempA = dijkstra(1, v2);
//        System.out.println(1 + " " +v2 +  " 비용 : " + tempA);
        Arrays.fill(dist, INF);
        tempB = dijkstra(v2,v1);
//        System.out.println(v2 + " " +v1 +  " 비용 : " + tempB);
        Arrays.fill(dist, INF);
        tempC = dijkstra(v1,N);
//        System.out.println(v1 + " " +N +  " 비용 : " + tempC);
        if  (tempA == INF || tempB == INF || tempC == INF) res2 = -1;
        else res2 = tempA + tempB + tempC;

        if (res1 == -1 && res2 == -1) System.out.println(-1);
        else if (res1 == -1) System.out.println(res2);
        else if (res2 == -1) System.out.println(res1);
        else System.out.println(res1 > res2 ? res2 : res1);

    }

    private static int dijkstra(int s, int e) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.offer(new Node(s,dist[s]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curV = node.v;
            int curW = node.w;
//            System.out.println(s+"->"+e +" 방문 : " + curV);


            if (curV == e) return dist[e];

            if (dist[curV] < curW) continue;

            for (int i = 1; i <= N; i++) {
                if (graph[curV][i] == 0) continue;
                if (curW + graph[curV][i] < dist[i]){
                    dist[i] = curW + graph[curV][i];
                    pq.offer(new Node(i, dist[i]));
                }
            }


        }
        return dist[e];
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] map, cost;
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private static class Node implements Comparable<Node> {
       int x;
       int y;
       int w;
       Node(int x, int y, int w) {
           this.x = x;
           this.y = y;
           this.w = w;
       }
        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.w, node.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M+1][N+1];
        cost = new int[M+1][N+1];
        for (int i = 1; i <= M; i++) {
            String s = br.readLine();
            Arrays.fill(cost[i], 100000);
            for (int j = 0; j < N; j++) {
                map[i][j+1] = s.charAt(j) - '0';
            }
        }
        dijkstra();
        System.out.println(cost[M][N]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        cost[1][1] = 0;
        pq.offer(new Node(1,1,cost[1][1]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int curX = curr.x;
            int curY = curr.y;
            int curW = curr.w;

            if (curX == M && curY == N) return;
            if (curW > cost[curX][curY]) continue;

            for (int i = 0; i < dirs.length; i++) {
                int px = curX + dirs[i][0];
                int py = curY + dirs[i][1];

                if (px < 1 || px > M || py < 1 || py > N) continue;

                if (curW + map[curX][curY] < cost[px][py]) {
                    cost[px][py] = curW + map[px][py];
                    pq.offer(new Node(px,py,cost[px][py]));
                }
            }
        }
    }
}

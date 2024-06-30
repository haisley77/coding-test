import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static long[][] cost, map;
    private static int N;

    private static class Pair implements Comparable<Pair> {
        long dist;
        int x;
        int y;
        Pair(long dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            return Long.compare(this.dist, p.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new long[N+1][N+1];
        cost = new long[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Long.parseLong(st.nextToken());
                cost[i][j] = Long.MAX_VALUE;
            }
        }
        dijkstra();
        System.out.println(cost[N][N]);
    }
    
    private static void dijkstra() {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int x = 1;
        int y = 1;

        cost[x][y] = 0;
        pq.offer(new Pair(cost[x][y], x, y));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            for (int i = 0; i < dirs.length; i++) {
                int px = cur.x + dirs[i][0];
                int py = cur.y + dirs[i][1];
                if (px < 1 || px > N || py < 1 || py > N) continue;
                long newDist = Math.max(cur.dist, Math.abs(map[px][py] - map[cur.x][cur.y]));

                if (cost[px][py] > newDist) {
                    cost[px][py] = newDist;
                    pq.offer(new Pair(newDist,px,py));
                }
            }
        }
    }
}

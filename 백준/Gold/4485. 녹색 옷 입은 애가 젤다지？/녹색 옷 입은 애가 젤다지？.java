import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int w;

        Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node node){
            return Integer.compare(this.w, node.w);
        }

    }
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 0;
        while (true) {
            t++;
            int N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            pq.offer(new Node(0,0,map[0][0]));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                for (int i = 0; i < dirs.length; i++) {
                    int nx = cur.x + dirs[i][0];
                    int ny = cur.y + dirs[i][1];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (dist[nx][ny] > cur.w + map[nx][ny]) {
                        dist[nx][ny] = cur.w + map[nx][ny];
                        pq.offer(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }

            sb.append("Problem ").append(t).append(": ").append(dist[N-1][N-1]).append("\n");
        }

        System.out.println(sb);
    }
}

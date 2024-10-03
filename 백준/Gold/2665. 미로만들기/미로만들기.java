import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static int[][] visited;
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = (s.charAt(j) - '0' + 1) % 2;
            }
        }
        // 0 -> 흰방
        // 1 -> 검은방
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0,map[0][0]));
        visited[0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < dirs.length; i++) {
                int nx = cur.x + dirs[i][0];
                int ny = cur.y + dirs[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] != Integer.MAX_VALUE) continue;

                if (cur.dist + map[nx][ny] < visited[nx][ny]) {
                    visited[nx][ny] = cur.dist + map[nx][ny];
                }
                pq.offer(new Node(nx,ny,visited[nx][ny]));
            }

        }
        System.out.println(visited[n-1][n-1]);

    }
}

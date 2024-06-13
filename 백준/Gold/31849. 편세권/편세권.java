import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<Point> q = new LinkedList<>();
    private static int res = Integer.MAX_VALUE;
    private static class Point {
        int startX;
        int startY;
        int x;
        int y;
        Point(int startX, int startY, int x, int y) {
            this.startX = startX;
            this.startY = startY;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            map[a][b] = p;
        }
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.offer(new Point(c,d,c,d));
            visited[c][d] = true;
        }
        
        calcScore();
        System.out.println(res);
    }

    private static void calcScore() {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < dirs.length; i++) {
                int px = cur.x + dirs[i][0];
                int py = cur.y + dirs[i][1];
                if (px < 1 || px > N || py < 1 || py > M || visited[px][py]) continue;

                if (map[px][py] != 0) {
                    int cost = getDist(cur.startX, cur.startY, px, py) * map[px][py];
                    if (res > cost) res = cost;
                }
                visited[px][py] = true;
                q.offer(new Point(cur.startX, cur.startY, px, py));
            }
        }
    }

    private static int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}
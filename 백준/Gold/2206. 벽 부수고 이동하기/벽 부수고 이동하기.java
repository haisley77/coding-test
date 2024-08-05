import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, res = Integer.MAX_VALUE;
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][][] visited;
    static int[][] map;
    static boolean ok;

    static class Node {
        int x;
        int y;
        int dist;
        boolean flag;
        Node(int x, int y, int dist, boolean flag) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.flag = flag;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
        if (ok) System.out.println(res);
        else System.out.println(-1);
    }

    private static void bfs() {

        Queue<Node> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.offer(new Node(0,0,1,false));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N-1 && cur.y == M-1) {
                res = Integer.min(res, cur.dist);
                ok = true;
                return;
             }

            for (int i = 0; i < dirs.length; i++) {
                int nx = cur.x + dirs[i][0];
                int ny = cur.y + dirs[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (map[nx][ny] == 1) {
                    if (!cur.flag) {
                        if (!visited[nx][ny][0]) {
                            visited[nx][ny][1] = true;
                            q.offer(new Node(nx,ny,cur.dist+1,true));
                        }
                    }
                } else {
                    if (cur.flag) {
                        if (!visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            q.offer(new Node(nx,ny,cur.dist+1,true));
                        }
                    } else {
                        if (!visited[nx][ny][0]) {
                            visited[nx][ny][0] = true;
                            q.offer(new Node(nx,ny,cur.dist+1,false));
                        }
                    }
                }
            }
        }
    }

}

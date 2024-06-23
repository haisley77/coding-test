import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) continue;
                bfs(i, j, map);
            }
        }
        System.out.println(res);
    }

    private static void bfs(int startX, int startY, int[][] map) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        map[startX][startY] = 0;
        q.offer(new int[]{startX,startY});

        int tmp = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < dirs.length; i++) {
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];

                if (px < 1 || px > N || py < 1 || py > M || map[px][py] == 0) continue;

                tmp += map[px][py];
                map[px][py] = 0;
                q.offer(new int[]{px,py});
            }
        }

        if (tmp > res) res = tmp;
    }
}

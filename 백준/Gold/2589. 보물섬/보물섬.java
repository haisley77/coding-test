import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M, res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'W') continue;
                res = Math.max(res, bfs(i, j, map));
            }
        }
        System.out.println(res);
    }
    private static int bfs(int x, int y, char[][] map) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();

        int[][] visited = new int[N][M];
        visited[x][y] = 1;
        q.offer(new int[]{x,y});

        int width = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dirs.length; i++){
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];

                if (px < 0 || px >= N || py < 0 || py >= M || visited[px][py] != 0 || map[px][py] == 'W') continue;

                visited[px][py] = visited[cur[0]][cur[1]] + 1;
                width = visited[px][py];

                q.offer(new int[]{px,py});
            }
        }

        return width-1;
    }
}

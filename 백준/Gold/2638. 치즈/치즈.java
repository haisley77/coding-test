import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] visited;
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            time++;
            visited = new boolean[N][M];

            bfs(0,0, map);

            if (removeCheese(map) == 0) {
                time--;
                break;
            }
        }
        System.out.println(time);
    }

    private static int removeCheese(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] < 2) continue;
                if (map[i][j] == 2) {
                    map[i][j] = 1;
                    continue;
                }
                if (map[i][j] >= 3) {
                    map[i][j] = 0;
                    cnt++;
                }

            }
        }
        return cnt;
    }

    private static void bfs(int sx, int sy, int[][] map) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dirs.length; i++) {
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];

                if (px < 0 || px >= N || py < 0 || py >= M || visited[px][py]) continue;

                if (map[px][py] > 0) {
                    map[px][py]++;
                    continue;
                }
                if (map[px][py] == 0) {
                    visited[px][py] = true;
                    q.offer(new int[]{px, py});
                }
            }
        }
    }
}

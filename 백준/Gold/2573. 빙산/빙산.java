import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] checked;
    private static int[][] map;
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while (true) {
            time++;
            checked = new int[N][M];
            
            boolean[][] visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] || map[i][j] > 0) continue;
                    bfs(i, j, visited);
                }
            }

            boolean isMelted = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) continue;
                    map[i][j] -= checked[i][j];
                    if (map[i][j] < 0) map[i][j] = 0;
                    if (map[i][j] > 0) isMelted = false;
                }
            }

            if (isMelted) {
                time = 0;
                break;
            }

            int cnt = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] || map[i][j] == 0) continue;
                    bfsForCounting(i, j, visited);
                    cnt++;

                }
            }

            if (cnt >= 2) break;
            
        }
        System.out.println(time);
    }

    private static void bfsForCounting(int startX, int startY, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();

        visited[startX][startY] = true;
        q.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dirs.length; i++) {
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];
                if (px < 0 || px >= N || py < 0 || py >= M || visited[px][py]) continue;
                if (map[px][py] == 0) continue;
                visited[px][py] = true;
                q.offer(new int[]{px, py});
            }
        }
    }

    private static void bfs(int startX, int startY, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();

        visited[startX][startY] = true;
        q.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dirs.length; i++) {
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];
                if (px < 0 || px >= N || py < 0 || py >= M || visited[px][py]) continue;
                if (map[px][py] > 0) {
                    checked[px][py]++;
                    continue;
                }
                visited[px][py] = true;
                q.offer(new int[]{px, py});
            }
        }
    }
}

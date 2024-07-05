import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, cheese;
    private static boolean[][] checked;
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese++;
            }
        }

        int time = 0;
        while (true) {
            time++;
            bfs(0,0,map);
            int res = removeCheese(map);
            if (cheese == 0) {
                System.out.println(time);
                System.out.println(res);
                break;
            }
        }
    }

    private static int removeCheese(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!checked[i][j]) continue;
                map[i][j] = 0;
                checked[i][j] = false;
                cnt++;
                cheese--;
            }
        }
        return cnt;
    }

    private static void bfs(int startX, int startY, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[startX][startY] = true;
        q.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dirs.length; i++) {
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];

                if (px < 0 || px >= N || py < 0 || py >= M || visited[px][py]) continue;

                if (map[px][py] == 1) {
                    checked[px][py] = true;
                    continue;
                }
                visited[px][py] = true;
                q.offer(new int[]{px,py});
            }
        }
    }
}

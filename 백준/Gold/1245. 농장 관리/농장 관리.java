import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] visited;
    private static int N, M, res;
    private static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == 0) continue;
                if (bfs(i, j, map)) res++;
            }
        }
        System.out.println(res);

    }

    private static boolean bfs(int startX, int startY, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean flag = true;
        visited[startX][startY] = true;
        q.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dirs.length; i++) {
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];

                if (px < 0 || px >= N || py < 0 || py >= M) continue;
                if (map[px][py] > map[startX][startY]) flag = false;
                if (map[px][py] != map[startX][startY]) continue;
                if (visited[px][py]) continue;

                visited[px][py] = true;
                q.offer(new int[]{px,py});
            }
        }
        return flag;
    }
}

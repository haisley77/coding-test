 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 import java.util.Arrays;
 import java.util.StringTokenizer;

public class Main {
    private static int[][] memo;
    private static int M, N, res;
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(dfs(0,0));


    }
    private static int dfs(int curx, int cury) {

        if (curx == M-1 && cury == N-1) {
            return 1;
        }

        if (memo[curx][cury] != -1) {
            return memo[curx][cury];
        }

        memo[curx][cury] = 0;
        for (int i = 0; i < dirs.length; i++) {
            int px = curx + dirs[i][0];
            int py = cury + dirs[i][1];

            if (px < 0 || px >= M || py < 0 || py >= N) continue;

            if (map[px][py] < map[curx][cury]) {
                 memo[curx][cury] += dfs(px, py);

            }
        }
        return memo[curx][cury];
    }
}

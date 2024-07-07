import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int R, C, K, res;
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        dfs(R-1,0,1);
        System.out.println(res);
    }
    private static void dfs(int x, int y, int cnt) {
        if (x == 0 && y == C-1) {
            if (cnt == K) res++;
            return;
        }
        map[x][y] = 'T';
        for (int i = 0; i < dirs.length; i++) {
            int px = x + dirs[i][0];
            int py = y + dirs[i][1];
            if (px < 0 || px >= R || py < 0 || py >= C || map[px][py] == 'T') continue;
            dfs(px,py,cnt+1);
        }
        map[x][y] = '.';
    }
}

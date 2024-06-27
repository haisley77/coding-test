import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private static int R, C, res;
    private static char[][] map;
    private static boolean ok;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            String s = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = s.charAt(j-1);
            }
        }
        boolean[] checked = new boolean[26];
        checked[map[1][1]-'A'] = true;
        move(1, 1, 1, new boolean[R+1][C+1], checked);
        System.out.println(res);
    }
    private static void move(int cnt, int x, int y, boolean[][] visited, boolean[] checked) {
        if (ok) return;
        if (cnt == R * C) {
            res = cnt;
            ok = true;
            return;
        }
        for (int i = 0; i < dirs.length; i++) {
            int px = x + dirs[i][0];
            int py = y + dirs[i][1];
            if (px < 1 || px > R || py < 1 || py > C || visited[px][py]) continue;
            if (possible(px,py,checked)) {
                checked[map[px][py] - 'A'] = true;
                visited[px][py] = true;
                move(cnt+1, px, py, visited, checked);
                checked[map[px][py] - 'A'] = false;
                visited[px][py] = false;
            } else {
                if (res < cnt) res = cnt;
            }
        }
    }
    private static boolean possible(int x, int y, boolean[] checked) {
        for (int i = 0; i < checked.length; i++) {
            if (checked[map[x][y] - 'A']) return false;
        }
        return true;
    }
}

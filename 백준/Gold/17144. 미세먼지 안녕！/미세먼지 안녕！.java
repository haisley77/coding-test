import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int hx, hy, lx, ly;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        int hx = 0;
        int hy = 0;
        int lx = 0;
        int ly = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    lx = i;
                    ly = j;
                }
            }
        }
        hx = lx - 1;
        hy = ly;

        for (int t = 0; t < T; t++) {
            
            int [][] newMap = new int[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    newMap[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < R; i++) {
                for (int k = 0; k < C; k++) {
                    if (map[i][k] < 5) continue;

                    int amt = map[i][k] / 5;
                    for (int j = 0; j < dirs.length; j++) {
                        int nx = i + dirs[j][0];
                        int ny = k + dirs[j][1];

                        if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) continue;
                        newMap[i][k] -= amt;
                        newMap[nx][ny] += amt;
                    }
                }
            }

            for (int i = hx-1; i > 0; i--) {
                newMap[i][hy] = newMap[i-1][hy];
            }
            for (int i = hy; i < C-1; i++) {
                newMap[0][i] = newMap[0][i+1];
            }
            for (int i = 0; i < hx; i++) {
                newMap[i][C-1] = newMap[i+1][C-1];
            }
            for (int i = C-1; i > hy+1; i--) {
                newMap[hx][i] = newMap[hx][i-1];
            }
            newMap[hx][hy+1] = 0;

            for (int i = lx+1; i < R-1; i++) {
                newMap[i][ly] = newMap[i+1][ly];
            }
            for (int i = ly; i < C-1; i++) {
                newMap[R-1][i] = newMap[R-1][i+1];
            }
            for (int i = R-1; i > lx; i--) {
                newMap[i][C-1] = newMap[i-1][C-1];
            }

            for (int i = C-1; i > ly+1; i--) {
                newMap[lx][i] = newMap[lx][i-1];
            }
            newMap[lx][ly+1] = 0;

            map = newMap;

        }

        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) continue;
                res += map[i][j];
            }
        }
        System.out.println(res);

    }
}

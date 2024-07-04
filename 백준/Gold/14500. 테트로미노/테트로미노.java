import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] dirs = {
            // 회전
            {{0, 1}, {0, 2}, {0, 3}},
            {{1, 0}, {2, 0}, {3, 0}},
            {{1, 0}, {0, 1}, {1, 1}},
            {{1, 0}, {2, 0}, {2, 1}},
            {{1, 0}, {0, 1}, {0, 2}},
            {{0, 1}, {1, 1}, {2, 1}},
            {{1, 0}, {1, -1}, {1, -2}},
            {{1, 0}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 0}, {1, -1}},
            {{0, 1}, {1, 1}, {0, 2}},
            {{1, 0}, {2, 0}, {1, -1}},
            {{1, -1}, {1, 0}, {1, 1}},
            {{1, 0}, {2, 0}, {1, 1}},
            // 대칭
            {{0, 1}, {1, 0}, {2, 0}},
            {{0, 1}, {0, 2}, {1, 2}},
            {{1, 0}, {2, 0}, {2, -1}},
            {{1, 0}, {1, 1}, {1, 2}},
            {{1, 0}, {1, -1}, {2, -1}},
            {{0, 1}, {1, 1}, {1, 2}}
    };
    private static int N, M, res;

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
        search(map);
        System.out.println(res);
    }

    private static void search(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int sum = map[i][j];
                sum += getMax(i, j, map);
                if (res < sum) res = sum;
            }
        }
    }

    private static int getMax(int x, int y, int[][] map) {
        int tmpMax = 0;
        for (int i = 0; i < dirs.length; i++) {
            int tmp = 0;
            for (int j = 0; j < 3; j++) {
                int[] cur = dirs[i][j];
                int curx = x + cur[0];
                int cury = y + cur[1];
                if (curx < 0 || curx >= N || cury < 0 || cury >= M) continue;
                tmp += map[curx][cury];
            }
            if (tmpMax < tmp) tmpMax = tmp;
        }
        return tmpMax;
    }
}

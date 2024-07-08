import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<int[]> list = new ArrayList<>();
    private static int[][] map, tmpMap;
    private static int[] maxCnt = {0,4,2,4,4,1};
    private static int[] cases;
    private static int N, M, res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        tmpMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                tmpMap[i][j] = map[i][j];
                if (map[i][j] == 0 || map[i][j] == 6) continue;
                list.add(new int[] {i, j});
            }
        }
        cases = new int[list.size()];
        perm(0);
        System.out.println(res);

    }
    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = tmpMap[i][j];
            }
        }
    }

    private static void perm(int cnt) {

        if (cnt == list.size()) {
            observe();
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) tmp++;
                }
            }
            if (tmp < res) res = tmp;
            copy();
            return;
        }

        int[] cur = list.get(cnt);
        int curX = cur[0];
        int curY = cur[1];
        int cctv = map[curX][curY];

        for (int i = 1; i <= maxCnt[cctv]; i++) {
            cases[cnt] = i;
            perm(cnt+1);
        }

    }

    private static void observe() {

        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            int curX = cur[0];
            int curY = cur[1];
            int cctv = map[curX][curY];

            if (cctv == 1) {
                if (cases[i] == 1) {
                    searchRight(curX, curY);
                    continue;
                }
                if (cases[i] == 2) {
                    searchDown(curX, curY);
                    continue;
                }
                if (cases[i] == 3) {
                    searchLeft(curX, curY);
                    continue;
                }
                if (cases[i] == 4) {
                    searchUp(curX, curY);
                    continue;
                }
            }
            if (cctv == 2) {
                if (cases[i] == 1) {
                    searchLeft(curX, curY);
                    searchRight(curX, curY);
                    continue;
                }
                if (cases[i] == 2) {
                    searchUp(curX, curY);
                    searchDown(curX, curY);
                    continue;
                }
            }
            if (cctv == 3) {
                if (cases[i] == 1) {
                    searchUp(curX, curY);
                    searchRight(curX, curY);
                    continue;
                }
                if (cases[i] == 2) {
                    searchRight(curX, curY);
                    searchDown(curX, curY);
                    continue;
                }
                if (cases[i] == 3) {
                    searchLeft(curX, curY);
                    searchDown(curX, curY);
                    continue;
                }
                if (cases[i] == 4) {
                    searchLeft(curX, curY);
                    searchUp(curX, curY);
                    continue;
                }
            }
            if (cctv == 4) {
                if (cases[i] == 1) {
                    searchLeft(curX, curY);
                    searchRight(curX, curY);
                    searchUp(curX, curY);
                    continue;
                }
                if (cases[i] == 2) {
                    searchRight(curX, curY);
                    searchUp(curX, curY);
                    searchDown(curX, curY);
                    continue;
                }
                if (cases[i] == 3) {
                    searchLeft(curX, curY);
                    searchDown(curX, curY);
                    searchRight(curX, curY);
                    continue;
                }
                if (cases[i] == 4) {
                    searchDown(curX, curY);
                    searchLeft(curX, curY);
                    searchUp(curX, curY);
                    continue;
                }
            }
            if (cctv == 5) {
                searchRight(curX, curY);
                searchUp(curX, curY);
                searchLeft(curX, curY);
                searchDown(curX, curY);
                continue;
            }
        }
    }

    private static void searchRight(int x, int y) {
        int px = x;
        int py = y;
        while (py >= 0 && py < M) {
            if (px == x && py == y) {
                py++;
                continue;
            }
            if (map[px][py] > 0) {
                if (map[px][py] == 6) return;
                else {
                    py++;
                    continue;
                }
            }
            map[px][py++] = -1;

        }
    }

    private static void searchLeft(int x, int y) {
        int px = x;
        int py = y;
        while (py >= 0 && py < M) {
            if (px == x && py == y) {
                py--;
                continue;
            }
            if (map[px][py] > 0) {
                if (map[px][py] == 6) return;
                else {
                    py--;
                    continue;
                }
            }
            map[px][py--] = -1;
        }
    }

    private static void searchUp(int x, int y) {
        int px = x;
        int py = y;
        while (px >= 0 && px < N) {
            if (px == x && py == y) {
                px--;
                continue;
            }
            if (map[px][py] > 0) {
                if (map[px][py] == 6) return;
                else {
                    px--;
                    continue;
                }
            }
            map[px--][py] = -1;
        }
    }

    private static void searchDown(int x, int y) {
        int px = x;
        int py = y;
        while (px >= 0 && px < N) {
            if (px == x && py == y) {
                px++;
                continue;
            }
            if (map[px][py] > 0) {
                if (map[px][py] == 6) return;
                else {
                    px++;
                    continue;
                }
            }
            map[px++][py] = -1;
        }
    }
}

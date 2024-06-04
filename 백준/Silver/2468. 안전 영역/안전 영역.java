import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int max = Integer.MIN_VALUE;
    private static int[][] map;
    private static int N, res;
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (max < map[i][j]) max = map[i][j];
            }
        }
        for (int i = 0; i <= max; i++) {
            int tmp = checkMap(i);
            if (res < tmp) res = tmp;
        }
        System.out.println(res);
    }

    private static int checkMap(int height) {
        int[][] newMap = new int[N][N];
        int tmpRes = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= height) newMap[i][j] = 0;
                else newMap[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if (newMap[i][j] != 0) {
                    bfs(i, j, newMap);
                    tmpRes++;
                }
            }
        }
        return tmpRes;
    }

    private static void bfs(int startX, int startY, int[][] newMap) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX,startY});
        newMap[startX][startY] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int curX = curr[0];
            int curY = curr[1];
            for (int i = 0; i < 4; i++) {
                int px = curX + dirs[i][0];
                int py = curY + dirs[i][1];
                if (px < 0 || px >= N || py < 0 || py >= N || newMap[px][py] == 0) continue;
                q.offer(new int[]{px,py});
                newMap[px][py] = 0;
            }
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static int N, M, maxCnt;
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

        buildWall(0);
        System.out.println(maxCnt);

    }

    private static void buildWall(int cnt) {
        if (cnt == 3) {
            maxCnt = Integer.max(maxCnt, spreadVirus());
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) continue;
                map[i][j] = 1;
                buildWall(cnt+1);
                map[i][j] = 0;
            }
        }
    }

    private static int spreadVirus() {
        Queue<int[]> q = new LinkedList<>();
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
                if (newMap[i][j] == 2) q.offer(new int[]{i,j});
            }
        }

        while (!q.isEmpty()){
            int[] cur = q.poll();

            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || newMap[nx][ny] > 0) continue;
                newMap[nx][ny] = 2;
                q.offer(new int[]{nx,ny});
            }
        }

        return countSafeArea(newMap);

    }

    private static int countSafeArea(int[][] newMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newMap[i][j] > 0) continue;
                cnt++;
            }
        }
        return cnt;
    }

}

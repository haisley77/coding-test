import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean flag;
    static int N, M, T;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = bfs();
        if (res == -1 || res > T) System.out.println("Fail");
        else System.out.println(res);

    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0});

        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int sword = cur[2];

                if (x == N - 1 && y == M - 1) return time;

                for (int i = 0; i < dirs.length; i++) {
                    int px = cur[0] + dirs[i][0];
                    int py = cur[1] + dirs[i][1];

                    if (px < 0 || px >= N || py < 0 || py >= M) continue;

                    if (sword == 0) {
                        if (map[px][py] == 1 || visited[px][py][0]) continue;
                        if (map[px][py] == 2) {
                            visited[px][py][1] = true;
                            q.offer(new int[]{px,py,1});
                        } else {
                            visited[px][py][0] = true;
                            q.offer(new int[]{px,py,0});
                        }
                    } else {
                        if (visited[px][py][1]) continue;
                        visited[px][py][1] = true;
                        q.offer(new int[]{px,py,1});
                    }
                }
            }
            time++;

        }
        return -1;
    }
}

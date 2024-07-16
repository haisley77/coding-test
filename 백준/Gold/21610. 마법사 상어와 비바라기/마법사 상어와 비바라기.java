import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    static int[][] dirs2 = {{-1,-1},{-1,1},{1,-1},{1,1}};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1];
        ArrayList<int[]> cloud = new ArrayList<>();
        boolean[][] visited = new boolean[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud.add(new int[]{N-1,1});
        cloud.add(new int[]{N-1,2});
        cloud.add(new int[]{N,1});
        cloud.add(new int[]{N,2});
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            for (int j = 0; j < cloud.size(); j++) {
                int[] cur = cloud.get(j);

                int nx = (cur[0] + dirs[d][0] * s % N + N) % N;
                int ny = (cur[1] + dirs[d][1] * s % N + N) % N;
                nx = (nx == 0) ? N : nx;
                ny = (ny == 0) ? N : ny;

                visited[nx][ny] = true;
                map[nx][ny]++;          // #2
                q.offer(new int[]{nx,ny});
            }

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int j = 0; j < dirs2.length; j++) {
                    int nx = cur[0] + dirs2[j][0];
                    int ny = cur[1] + dirs2[j][1];
                    if (nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny] == 0) continue;
                    map[cur[0]][cur[1]]++;
                }
            }

            cloud.clear();
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (visited[j][k] || map[j][k] < 2) continue;
                    map[j][k] -= 2;
                    cloud.add(new int[]{j,k});
                }
            }

            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    visited[j][k] = false;
                }
            }

        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                res += map[i][j];
            }
        }
        System.out.println(res);


    }
}

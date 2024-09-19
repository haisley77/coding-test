import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
                if (i == 0 && map[i][j] == 0) {
                    map[i][j] = 2;
                    q.offer(new int[]{i,j});
                }
            }
        }
        boolean flag = false;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || map[nx][ny] == 2) continue;
                if (map[nx][ny] == 1) continue;

                if (nx == M-1) {
                    flag = true;
                }
                map[nx][ny] = 2;
                q.offer(new int[]{nx,ny});
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
}

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = {{1,0},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0] * map[cur[0]][cur[1]];
                int ny = cur[1] + dirs[i][1] * map[cur[0]][cur[1]];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                q.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
                if (nx == N-1 && ny == N-1) break;
            }
        }
        System.out.println(visited[N-1][N-1] ? "HaruHaru" : "Hing");
    }

}

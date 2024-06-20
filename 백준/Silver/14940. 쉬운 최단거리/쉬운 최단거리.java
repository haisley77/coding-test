import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] visited;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int startx = 0;
        int starty = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startx = i;
                    starty = j;
                }
            }
        }
        bfs(startx, starty, map);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    if (map[i][j] == 0) {
                        sb.append("0 ");
                    } else {
                        sb.append("-1 ");
                    }
                } else {
                    sb.append(visited[i][j] - 1).append(" ");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    private static void bfs(int startx, int starty, int[][] map) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        visited = new int[n][m];
        visited[startx][starty] = 1;
        q.offer(new int[]{startx, starty});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < dirs.length; i++) {
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];

                if (px < 0 || px >= n || py < 0 || py >= m || visited[px][py] >= 1) continue;
                if (map[px][py] == 0) continue;
                visited[px][py] = visited[cur[0]][cur[1]] + 1;
                q.offer(new int[]{px, py});
            }
        }
    }
}

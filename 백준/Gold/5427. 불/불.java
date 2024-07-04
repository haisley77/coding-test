import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private static Queue<int[]> fire;
    private static Queue<int[]> tmpFire;
    private static StringBuilder sb = new StringBuilder();
    private static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            fire = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];
            int startX = 0;
            int startY = 0;
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '@') {
                        startX = i;
                        startY = j;
                    }
                    if (map[i][j] == '*') {
                        fire.offer(new int[]{i,j});
                    }
                    if (i == 0 || i == h-1 || j == 0 || j == w-1) {
                        if (map[i][j] == '*' || map[i][j] == '#') cnt++;
                    }
                }
            }
            if (cnt == (w+h)*2) sb.append("IMPOSSIBLE").append("\n");
            else {
                int time = bfs(startX, startY, map);
                if (time == -1) sb.append("IMPOSSIBLE").append("\n");
                else sb.append(time).append("\n");
            }

        }
        System.out.println(sb);
    }

    private static int bfs(int startX, int startY, char[][] map) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[h][w];
        visited[startX][startY] = 1;
        q.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {
            spreadFire(map); 

            int qSize = q.size();
            for (int k = 0; k < qSize; k++) {
                int[] cur = q.poll();

                for (int i = 0; i < dirs.length; i++) {
                    int px = cur[0] + dirs[i][0];
                    int py = cur[1] + dirs[i][1];

                    if (px < 0 || px >= h || py < 0 || py >= w) {
                        return visited[cur[0]][cur[1]];
                    }
                    if (visited[px][py] > 0) continue;
                    if (map[px][py] == '*' || map[px][py] == '#') continue;

                    visited[px][py] = visited[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{px, py});
                }
            }
        }

        return -1;
    }

    private static void spreadFire(char[][] map) {
        int size = fire.size();

        for (int i = 0; i < size; i++) {
            int[] cur = fire.poll();
            for (int j = 0; j < dirs.length; j++) {
                int px = cur[0] + dirs[j][0];
                int py = cur[1] + dirs[j][1];
                if (px < 0 || px >= h || py < 0 || py >= w) continue;
                if (map[px][py] == '#' || map[px][py] == '*') continue;
                map[px][py] = '*';
                fire.offer(new int[]{px, py});
            }
        }

    }
}

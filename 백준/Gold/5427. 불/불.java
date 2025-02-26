import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static Queue<int[]> fq, sq;
    static boolean[][] visited;
    static int[][] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] map = new char[h][w];

            fq = new LinkedList<>();
            sq = new LinkedList<>();
            visited = new boolean[h][w];    // 불 방문체크
            time = new int[h][w];

            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '@') {
                        time[i][j] = 1;
                        sq.offer(new int[]{i, j});
                    }
                    if (map[i][j] == '*') {
                        visited[i][j] = true;
                        fq.offer(new int[]{i, j});
                    }
                }
            }

            int res = bfs(map, w, h);
            if (res == -1) sb.append("IMPOSSIBLE").append("\n");
            else sb.append(res).append("\n");

        }
        System.out.println(sb);
    }

    private static int bfs(char[][] map, int w, int h) {

        while (!sq.isEmpty()) {

            // 불 이동
            int qSize = fq.size();
            for (int k = 0; k < qSize; k++){
                int[] fire = fq.poll();

                for (int i = 0; i < dirs.length; i++) {
                    int nx = fire[0] + dirs[i][0];
                    int ny = fire[1] + dirs[i][1];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny]) continue;

                    if (map[nx][ny] == '.' || map[nx][ny] == '@') {
                        visited[nx][ny] = true;
                        map[nx][ny] = '*';
                        fq.offer(new int[]{nx,ny});
                    }

                }

            }

            // 상근 이동
            qSize = sq.size();
            for (int k = 0; k < qSize; k++) {
                int[] cur = sq.poll();

                for (int i = 0; i < dirs.length; i++) {
                    int nx = cur[0] + dirs[i][0];
                    int ny = cur[1] + dirs[i][1];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) return time[cur[0]][cur[1]];

                    if (time[nx][ny] > 0) continue;

                    if (map[nx][ny] == '.' || map[nx][ny] == '@') { //
                        time[nx][ny] = time[cur[0]][cur[1]] + 1;
                        sq.offer(new int[]{nx,ny});
                    }

                }
            }

        }

        return -1;

    }

}
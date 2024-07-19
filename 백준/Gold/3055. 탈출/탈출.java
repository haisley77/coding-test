import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static Queue<int[]> water = new LinkedList<>();
    static Queue<int[]> q = new LinkedList<>();
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static char[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        int[][] visited = new int[R][C];

        int endX = 0;
        int endY = 0;

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    visited[i][j] = 1;
                    map[i][j] = '.';
                    q.offer(new int[]{i, j});
                }
                if (map[i][j] == '*') {
                    water.offer(new int[]{i, j});
                }
                if (map[i][j] == 'D') {
                    endX = i;
                    endY = j;
                }
            }
        }

        while (true) {

            int size = water.size();
            for (int i = 0; i < size; i++) {
                int[] cur = water.poll();

                for (int j = 0; j < dirs.length; j++) {
                    int nx = cur[0] + dirs[j][0];
                    int ny = cur[1] + dirs[j][1];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        water.offer(new int[]{nx, ny});
                    }
                }
            }

            size = q.size();
            boolean flag = false;
            xx:
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int j = 0; j < dirs.length; j++) {
                    int nx = cur[0] + dirs[j][0];
                    int ny = cur[1] + dirs[j][1];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] > 1) continue;


                    if (map[nx][ny] == '.') {
                        visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                        flag = true;
                        q.offer(new int[]{nx,ny});
                    }
                    if (map[nx][ny] == 'D'){
                        visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                        break xx;
                    }

                }
            }

            if (!flag) break;
            if (q.isEmpty()) break;

        }

        if (visited[endX][endY] == 0) System.out.println("KAKTUS");
        else System.out.println(visited[endX][endY] - 1);
    }

}

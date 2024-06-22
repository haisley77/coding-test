import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int[][] dirs = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
        Queue<int[]> q = new LinkedList<>();
        map[r1][c1] = 1;
        q.offer(new int[]{r1,c1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == r2 && cur[1] == c2) break;

            for (int i = 0; i <dirs.length; i++) {
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];

                if (px < 0 || px >= N || py < 0 || py >= N || map[px][py] != 0) continue;

                map[px][py] = map[cur[0]][cur[1]] + 1;
                q.offer(new int[]{px,py});
            }
        }

        System.out.println(map[r2][c2] - 1);
    }
}

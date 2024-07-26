import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1];
        int[][] dirs = {{-2,-1},{-2,1},{-1,-2},{-1,2},
                {1,-2},{1,2},{2,-1},{2,1}};

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        Queue<int[]> arrival = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = -1; // 도착지점
            arrival.offer(new int[]{x, y});
        }
        int ansSize = arrival.size();

        Queue<int[]> q = new LinkedList<>();
        map[startX][startY] = 1;
        q.offer(new int[]{startX, startY});

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dirs.length; i++) {
                int nx = cur[0] + dirs[i][0];
                int ny = cur[1] + dirs[i][1];

                if (nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny] > 0) continue;

                if (map[nx][ny] == -1) cnt++;
                map[nx][ny] = map[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
            if (cnt == ansSize) break;
        }

        StringBuilder sb = new StringBuilder();
        while (!arrival.isEmpty()) {
            int[] cur = arrival.poll();
            sb.append(map[cur[0]][cur[1]]-1).append(" ");
        }
        System.out.println(sb);

    }
}

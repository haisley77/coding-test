import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayDeque<int[]> ad = new ArrayDeque<>();
    private static int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    private static int d = 1;
    private static int time;
    private static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            if (c == 'L') {
                q.offer(new int[]{x,1});
            } else {
                q.offer(new int[]{x,2});
            }
        }

        ad.offerFirst(new int[]{1,1});
        map[1][1] = 2;
        playGame(N, map);

        System.out.println(time);

    }

    private static void playGame(int N, int[][] map) {

        while (true) {
            time++;

            int[] cur = ad.peekFirst();
            int nx = cur[0] + dirs[d][0];
            int ny = cur[1] + dirs[d][1];

            if (nx  < 1 || nx  > N || ny  < 1 || ny  > N || map[nx][ny] == 2) {
                return;
            }

            if (map[nx][ny] == 0) {
                int[] tail = ad.pollLast();
                map[tail[0]][tail[1]] = 0;
            }
            map[nx][ny] = 2;
            ad.offerFirst(new int[]{nx, ny});

            if (!q.isEmpty() && q.peek()[0] == time) {
                if (q.poll()[1] == 1) d = (d + 3) % 4;
                else d = (d + 1) % 4;
            }

        }
    }
}

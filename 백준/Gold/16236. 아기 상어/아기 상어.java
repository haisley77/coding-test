import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int dist;
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish f) {
            if (this.dist != f.dist) return Integer.compare(this.dist, f.dist);
            if (this.x != f.x) return Integer.compare(this.x, f.x);
            if (this.y != f.y) return Integer.compare(this.y, f.y);
            return 0;
        }
    }
    static int N, M, sharkX, sharkY, size, cnt, res;
    static int[][] map;
    static PriorityQueue<Fish> pq = new PriorityQueue<>();
    static int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    continue;
                }
                if (map[i][j] > 0) {
                    M++;
                }
            }
        }

        size = 2;
        playGame();
        System.out.println(res);
    }


    private static void playGame() {
        int[][] visited = new int[N][N];
        visited[sharkX][sharkY] = 1;
        pq.offer(new Fish(sharkX, sharkY, 1));

        while (!pq.isEmpty()) {
            Fish cur = pq.poll();
            if (M == 0) break;

            if (map[cur.x][cur.y] != 9 && map[cur.x][cur.y] != 0 && (map[cur.x][cur.y] < size)) {
                res += (cur.dist - 1);
                map[cur.x][cur.y] = 9;
                map[sharkX][sharkY] = 0;
                sharkX = cur.x;
                sharkY = cur.y;
                pq.clear();
                cnt++;
                M--;

                visited = new int[N][N];
                visited[sharkX][sharkY] = 1;

                cur = new Fish(sharkX, sharkY, 1);

                if (cnt == size) {
                    cnt = 0;
                    size++;
                }
            }

            for (int i = 0; i < dirs.length; i++) {
                int nx = cur.x + dirs[i][0];
                int ny = cur.y + dirs[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] > 0) continue;
                if (map[nx][ny] > size) continue;

                visited[nx][ny] = visited[cur.x][cur.y] + 1;
                pq.offer(new Fish(nx, ny,visited[nx][ny]));
            }

        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R, C;
    static int[][] map = new int[1001][1001];
    static int[][] check = new int[1001][1001];
    static List<Room> house = new ArrayList<>();
    static Queue<QueueNode> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = Integer.MAX_VALUE;

    static class Room {
        int x, y, price;
        Room(int x, int y, int price) {
            this.x = x;
            this.y = y;
            this.price = price;
        }
    }

    static class QueueNode {
        int combiX, combiY, x, y;
        QueueNode(int combiX, int combiY, int x, int y) {
            this.combiX = combiX;
            this.combiY = combiY;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int cnt = 1;
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            house.add(new Room(x, y, cost));
            map[x][y] = cnt++;
        }

        for (int i = 1; i <= C; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            q.offer(new QueueNode(x, y, x, y));
            check[x][y] = 1;
        }

        solve();
        System.out.println(ans);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            QueueNode node = q.poll();
            int combiX = node.combiX;
            int combiY = node.combiY;
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if (xx >= 1 && xx <= N && yy >= 1 && yy <= M) {
                    if (check[xx][yy] != 0) continue;

                    if (map[xx][yy] != 0) {
                        int houseIndex = map[xx][yy] - 1;
                        int distance = (Math.abs(combiX - xx) + Math.abs(combiY - yy)) * house.get(houseIndex).price;
                        ans = Math.min(ans, distance);
                    }

                    check[xx][yy] = 1;
                    q.offer(new QueueNode(combiX, combiY, xx, yy));
                }
            }
        }
    }

    static void solve() {
        bfs();
    }
}

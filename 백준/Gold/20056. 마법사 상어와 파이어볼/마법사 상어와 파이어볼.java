import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class QNode {
        int r;
        int c;
        int m;
        int d;
        int s;
        QNode(int r, int c, int m, int d, int s) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }
    static class Node {
        int m;
        int d;
        int s;
        Node next;

        Node(int m, int d, int s, Node next) {
            this.m = m;
            this.d = d;
            this.s = s;
            this.next = next;
        }
    }
    static int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    static int N, M, K;
    static Node[][] map;
    static int[][] count;
    static Queue<QNode> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Node[N][N];
        count = new int[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            count[r-1][c-1]++;
            map[r-1][c-1] = new Node(m,d,s,map[r-1][c-1]);
            q.offer(new QNode(r-1,c-1,m,d,s));
        }

        for (int i = 0; i < K; i++) {
            move();
        }

        int res = 0;
        while (!q.isEmpty()) {
            res += q.poll().m;
        }
        System.out.println(res);

    }

    private static void move() {
        Node[][] newMap = new Node[N][N];

        while (!q.isEmpty()) {
            QNode cur = q.poll();
            int nx = (cur.r + dirs[cur.d][0] * cur.s % N + N) % N;
            int ny = (cur.c + dirs[cur.d][1] * cur.s % N + N) % N;

            newMap[nx][ny] = new Node(cur.m, cur.d, cur.s, newMap[nx][ny]);
            count[cur.r][cur.c]--;
            count[nx][ny]++;
        }

        map = newMap;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (count[i][j] == 0) continue;
                if (count[i][j] == 1) {
                    if (map[i][j].m != 0) {
                        q.offer(new QNode(i,j,map[i][j].m, map[i][j].d, map[i][j].s));
                    }
                    continue;
                }

                int totalM = 0;
                int totalS = 0;
                int startD = map[i][j].d % 2;
                boolean flag = true;
                for (Node cur = map[i][j]; cur != null; cur = cur.next) {
                    if (cur.d % 2 != startD) flag = false;
                    totalM += cur.m;
                    totalS += cur.s;
                }

                int nextM = totalM / 5;
                int nextS = totalS / count[i][j];

                if (nextM == 0) {
                    map[i][j] = null;
                    count[i][j] = 0;
                    continue;
                }

                if (flag) {
                    for (int d = 0; d < 8; d += 2) {
                        q.offer(new QNode(i,j,nextM,d,nextS));
                    }
                } else {
                    for (int d = 1; d < 8; d += 2) {
                        q.offer(new QNode(i, j, nextM, d, nextS));
                    }
                }
                count[i][j] = 4;

            }
        }
    }

}

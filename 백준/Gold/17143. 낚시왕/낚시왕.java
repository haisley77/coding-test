import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        int r;
        int c;
        int s;        
        int d;         
        int z;        

        Node(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    private static Node[][] map;
    private static int curCol, R, C, res;
    private static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new Node[R+1][C+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Node(r,c,s,d,z);
            q.offer(map[r][c]);
        }
        play();
        System.out.println(res);

    }

    private static void play() {
        for (curCol = 1; curCol <= C; curCol++) {
            goNext();
            move();
        }
    }

    private static void goNext() {
        for (int i = 1; i <= R; i++) {
            if (map[i][curCol] == null) continue;
            res += map[i][curCol].z;
            map[i][curCol] = null;
            break;
        }
    }

    private static void move(){
        int size = q.size();
        Node[][] newMap = new Node[R+1][C+1];
        Queue<Node> newQ = new LinkedList<>();

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 비어있거나, 이미잡아먹힌 경우
            if (map[cur.r][cur.c] == null || map[cur.r][cur.c].z != cur.z) continue;

            int px = cur.r;
            int py = cur.c;
            int distance = cur.s;
            int dir = cur.d-1;

            while (distance > 0) {

                if (dir == 0) {
                    if (px - distance > 0) {
                        px -= distance;
                        distance = 0;
                    } else {
                        distance -= (px - 1);
                        px = 1;
                        dir = 1;
                    }
                } else if (dir == 1) {
                    if (px + distance <= R) {
                        px += distance;
                        distance = 0;
                    } else {
                        distance -= (R - px);
                        px = R;
                        dir = 0;
                    }
                } else if (dir == 2) {
                    if (py + distance <= C) {
                        py += distance;
                        distance = 0;
                    } else {
                        distance -= (C - py);
                        py = C;
                        dir = 3;
                    }
                } else if (dir == 3) {
                    if (py - distance > 0) {
                        py -= distance;
                        distance = 0;
                    } else {
                        distance -= (py - 1);
                        py = 1;
                        dir = 2;
                    }
                }

            }

            cur.r = px;
            cur.c = py;
            cur.d = dir + 1;

            if (newMap[px][py] == null || newMap[px][py].z < cur.z) {
                newMap[px][py] = cur;
                newQ.offer(cur);
            }
        }

        map = newMap;
        q = newQ;
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        Point[] graph = new Point[N];
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (dir == 1) graph[i] = new Point(0,dist);
            if (dir == 2) graph[i] = new Point(R,dist);
            if (dir == 3) graph[i] = new Point(dist, 0);
            if (dir == 4) graph[i] = new Point(dist, C);

        }
        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());
        int startX = 0, startY = 0;
        if (dir == 1) {
            startX = 0;
            startY = dist;
        }
        if (dir == 2) {
            startX = R;
            startY = dist;
        }
        if (dir == 3) {
            startX = dist;
            startY = 0;
        }
        if (dir == 4) {
            startX = dist;
            startY = C;
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            int x = graph[i].x;
            int y = graph[i].y;
            if (startX == 0) {  // 북
                //동
                if (y == C) res += (C - startY + x);
                //서
                if (y == 0) res += (startY + x);
                //남
                if (x == R) res += Math.min(y + startY + R, C - startY + C - y + R);
                //북
                if (x == 0) res += Math.abs(startY - y);
            } if (startX == R) {  // 남
                //동
                if (y == C) res += (C - startY + R - x);
                //서
                if (y == 0) res += (startY + R - x);
                //남
                if (x == R) res +=  Math.abs(startY - y);
                //북
                if (x == 0) res += Math.min(y + startY + R, C - startY + C - y + R);
            } if (startY == 0) {    // 서
                //동
                if (y == C) res += Math.min(x + startX + C, R - startX + R - x + C);
                //서
                if (y == 0) res += Math.abs(startX - x);
                //남
                if (x == R) res += (y + R - startX);
                //북
                if (x == 0) res += (startX + y);

            } if (startY == C) {  // 동
                //동
                if (y == C) res += Math.abs(startX - x);
                //서
                if (y == 0) res += Math.min(x + startX + C, R - startX + R - x + C);
                //남
                if (x == R) res += (R - startX + C - y);
                //북
                if (x == 0) res += (startX + C - y);
            }

        }
        System.out.println(res);

    }
}

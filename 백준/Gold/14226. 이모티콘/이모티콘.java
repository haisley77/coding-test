import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node {
        int screenCnt;
        int clipCnt;
        int t;
        Node(int screenCnt, int clipCnt, int t) {
            this.screenCnt = screenCnt;
            this.clipCnt = clipCnt;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int T = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[2001][2001];

        Queue<Node> q = new LinkedList<>();
        visited[1][0] = true;
        q.offer(new Node(1,0,0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.screenCnt == S) {
                System.out.println(cur.t);
                break;
            }

            // 클립보드에 복사
            if (cur.screenCnt <= 1000 && !visited[cur.screenCnt][cur.screenCnt]) {
                visited[cur.screenCnt][cur.screenCnt] = true;
                q.offer(new Node(cur.screenCnt, cur.screenCnt, cur.t + 1));
            }

            if (cur.clipCnt != 0 && (cur.screenCnt+cur.clipCnt <= 1000) && !visited[cur.screenCnt+cur.clipCnt][cur.clipCnt]) {
                visited[cur.screenCnt+cur.clipCnt][cur.clipCnt] = true;
                // 화면에 복사
                q.offer(new Node(cur.screenCnt + cur.clipCnt, cur.clipCnt, cur.t + 1));

            }
            // 화면 이모티콘 삭제
            if (cur.screenCnt != 0 && (cur.screenCnt-1 <= 1000) && !visited[cur.screenCnt-1][cur.clipCnt]) {
                visited[cur.screenCnt-1][cur.clipCnt] = true;
                q.offer(new Node(cur.screenCnt - 1,cur.clipCnt, cur.t + 1));
            }
        }


    }


}

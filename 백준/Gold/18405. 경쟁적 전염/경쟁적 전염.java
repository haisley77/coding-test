import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int vi;

        Node(int x, int y, int vi) {
            this.x = x;
            this.y = y;
            this.vi = vi;
        }

        @Override
        public int compareTo(Node node){
            return Integer.compare(this.vi, node.vi);
        }

    }

    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) continue;
                list.add(new Node(i,j,map[i][j]));
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        Collections.sort(list);

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            q.offer(list.get(i));
        }

        int time = 0;
        while (!q.isEmpty()) {
            list = new ArrayList<>();
            int size = q.size();

            if (time == S) break;

            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                for (int j = 0; j < dirs.length; j++) {
                    int nx = cur.x + dirs[j][0];
                    int ny = cur.y + dirs[j][1];

                    if (nx < 1 || nx > N || ny < 1 || ny > N || map[nx][ny] > 0) continue;
                    map[nx][ny] = cur.vi;
                    list.add(new Node(nx,ny,map[nx][ny]));
                }
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                q.offer(list.get(i));
            }
            time++;
        }

        System.out.println(map[X][Y]);
    }
}

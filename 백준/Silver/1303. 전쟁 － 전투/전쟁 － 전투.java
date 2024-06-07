import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, resW, resB;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++){
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                bfs(i,j);
            }
        }
        System.out.println(resW + " " + resB);
    }
    private static void bfs(int startX, int startY) {

        Queue<int[]> q = new LinkedList<>();
        int temp = 1;
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < dirs.length; i++) {
                int px = curr[0] + dirs[i][0];
                int py = curr[1] + dirs[i][1];
                if (px < 0 || px >= M || py < 0 || py >= N || visited[px][py] || map[px][py] != map[startX][startY]) continue;
                temp++;
                visited[px][py] = true;
                q.offer(new int[]{px,py});
            }
        }
        if (map[startX][startY] == 'W') resW += temp * temp;
        if (map[startX][startY] == 'B') resB += temp * temp;
    }
}

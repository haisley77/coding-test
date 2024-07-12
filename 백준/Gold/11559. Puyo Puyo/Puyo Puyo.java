import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int res = 0;
        while (true) {
            
            int cnt = 0;
            for (int j = 0; j < 6; j++) {
                for (int i = 0; i < 12; i++) {
                    if (map[i][j] == '.') continue;
                    if (bfs(i,j)) cnt++;
                }
            }
            
            if (cnt == 0) break;
            
            setMap();
            res++;
        }
        System.out.println(res);
    }

    private static boolean bfs(int startX, int startY) {
        Queue<int[]> tq = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];
        visited[startX][startY] = true;
        q.offer(new int[]{startX, startY});
        tq.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < dirs.length; i++) {
                int px = cur[0] + dirs[i][0];
                int py = cur[1] + dirs[i][1];

                if (px < 0 || px >= 12 || py < 0 || py >= 6 || visited[px][py]) continue;
                if (map[px][py] != map[startX][startY]) continue;

                visited[px][py] = true;
                q.offer(new int[]{px,py});
                tq.offer(new int[]{px,py});
            }
        }

        if (tq.size() >= 4) {
            while (!tq.isEmpty()) {
                int[] cur = tq.poll();
                map[cur[0]][cur[1]] = '.';
            }
            return true;
        }
        return false;
    }

    private static void setMap() {
        char[][] newMap = new char[12][6];
        for (int i = 0; i < 12; i++) {
            Arrays.fill(newMap[i], '.');
        }

        Queue<Character> tq = new LinkedList<>();
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 12; i++) {
                if (map[i][j] == '.') continue;
                tq.offer(map[i][j]);
            }
            int startIndex = 12 - tq.size();
            while (!tq.isEmpty()) {
                newMap[startIndex++][j] = tq.poll();
            }

        }
        map = newMap;
    }

}

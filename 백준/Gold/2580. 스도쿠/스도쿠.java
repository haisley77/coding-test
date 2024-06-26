import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] start = {0,0,0,3,3,3,6,6,6};
    private static boolean ok;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) q.offer(new int[]{i, j});
            }
        }
        sudoku(q, map);
    }

    private static void sudoku(Queue<int[]> q, int[][] map) {
        if (ok) return;
        if (q.isEmpty()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            ok = true;
            return;
        }
        int[] cur = q.poll();
        int x = cur[0];
        int y = cur[1];
        for (int i = 1; i <= 9; i++) {
            if (possible(i,x,y,map)) {
                map[x][y] = i;
                Queue<int[]> nextQueue = new LinkedList<>(q); // 큐 복사
                sudoku(nextQueue,map);
            }
            map[x][y]= 0;
        }
    }
    private static boolean possible(int i, int x, int y, int[][] map) {
        for (int j = 0; j < 9; j++) {
            if (j != y && map[x][j] == i) return false;
            if (j != x && map[j][y] == i) return false;
        }
        for (int j = start[x]; j < start[x] + 3; j++) {
            for(int k = start[y]; k < start[y] + 3; k++) {
                if (j == x && k == y) continue;
                if (map[j][k] == i) return false;
            }
        }
        return true;
    }
}

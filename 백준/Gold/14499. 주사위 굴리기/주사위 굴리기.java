import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dice = new int[7];
    static int[] status = new int[7];
    static int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken() );
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < 7; i++) status[i] = i;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int d = Integer.parseInt(st.nextToken());
            int nx = x + dirs[d-1][0];
            int ny = y + dirs[d-1][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            x = nx;
            y = ny;
            moveDice(d);

            if (map[x][y] == 0) {
                map[x][y] = dice[status[6]];
            } else {
                dice[status[6]] = map[x][y];
                map[x][y] = 0;
            }
            sb.append(dice[status[1]]).append("\n");

        }
        System.out.println(sb);

    }
    private static void moveDice(int d) {

        if (d == 1) {
            int temp = status[1];
            status[1] = status[4];
            status[4] = status[6];
            status[6] = status[3];
            status[3] = temp;
        } else if (d == 2) {
            int temp = status[1];
            status[1] = status[3];
            status[3] = status[6];
            status[6] = status[4];
            status[4] = temp;
        } else if (d == 3) {
            int temp = status[1];
            status[1] = status[5];
            status[5] = status[6];
            status[6] = status[2];
            status[2] = temp;
        } else if (d == 4) {
            int temp = status[1];
            status[1] = status[2];
            status[2] = status[6];
            status[6] = status[5];
            status[5] = temp;
        }
    }
}

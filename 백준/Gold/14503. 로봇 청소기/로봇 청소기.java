import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dirs1 = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] dirs2 = {{1,0},{0,-1},{-1,0},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        while (true) {

            if (map[r][c] == 0) {
                map[r][c] = 2;
                res++;
            }

            int cnt = 0;
            for (int i = 0; i < dirs1.length; i++) {
                int nx = r + dirs1[i][0];
                int ny = c + dirs1[i][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] > 0) continue;
                cnt++;
            }

            if (cnt > 0) {
                d = (d - 1 + 4) % 4;
                int nx = r + dirs1[d][0];
                int ny = c + dirs1[d][1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        r = nx;
                        c = ny;
                    }
                }
            } else {
                int nx = r + dirs2[d][0];
                int ny = c + dirs2[d][1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1) break;
                    r = nx;
                    c = ny;
                }
            }
        }
        
        System.out.println(res);
    }
}

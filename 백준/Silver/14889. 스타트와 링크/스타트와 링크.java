import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, res = Integer.MAX_VALUE;
    private static int[][] S;
    private static boolean[] team;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N+1][N+1];
        team = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(1,0);
        System.out.println(res);
    }

    private static void combi(int start, int cnt) {
        if (cnt == N/2) {
            int power1 = 0;
            int power2 = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    if (team[i] && team[j]) power1 += S[i][j];
                    if (!team[i] && !team[j]) power2 += S[i][j];
                }
            }
            int diff = 0;
            if (power1 > power2) diff = power1 - power2;
            else diff = power2 - power1;
            if (res > diff) res = diff;
            return;
        }

        for (int i = start; i <= N; i++) {
            team[i] = true;
            combi(i+1,cnt+1);
            team[i] = false;
        }
    }
}

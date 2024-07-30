import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] gears;
    static int[] top = new int[4];
    static int[] dir = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new int[5][8];
        for (int i = 1; i <= 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = s.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Arrays.fill(dir,0);
            dir[n] = d;
            checkRotationDirection(n);
            for (int j = 1; j <= 4; j++) {
                if (dir[j] == 1) {
                    top[j-1] = (top[j-1] + 7) % 8;
                }
                if (dir[j] == -1) {
                    top[j-1] = (top[j-1] + 1) % 8;
                }
            }
        }

        int res = 0;
        if (gears[1][top[0]] == 1) res += 1;
        if (gears[2][top[1]] == 1) res += 2;
        if (gears[3][top[2]] == 1) res += 4;
        if (gears[4][top[3]] == 1) res += 8;

        System.out.println(res);
        
    }

    private static void checkRotationDirection(int n) {

        int left = n - 1;
        int right = n + 1;

        int cur = n;
        while (left >= 1) {
            if (gears[left][(top[left-1] + 2) % 8] != gears[cur][(top[cur-1] + 6) % 8]) {
                dir[left] = dir[cur] * (-1);
            }
            
            if (dir[left] == 0) break;
            left--;
            cur--;

        }

        cur = n;
        while (right <= 4) {
            if (gears[cur][(top[cur-1] + 2) % 8] != gears[right][(top[right-1] + 6) % 8]) {
                dir[right] = dir[cur] * (-1);
            }

            if (dir[right] == 0) break;
            right++;
            cur++;
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Egg {
        int s;
        int w;
        boolean flag;

        Egg(int s, int w) {
            this.s = s;
            this.w = w;
            this.flag = true;
        }
    }
    private static Egg[] arr;
    private static int N, res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Egg[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            arr[i] = new Egg(S, W);
        }
        dfs(0);
        System.out.println(res);
    }

    private static void dfs(int cnt) {
        if (cnt == N) {
            int tmpRes = 0;
            for (int i = 0; i < N; i++) {
                if (!arr[i].flag) tmpRes++;
            }
            if (res < tmpRes) {
                res = tmpRes;
            }
            return;
        }

        if (!arr[cnt].flag) {
            dfs(cnt+1);
        } else {
            boolean canHit = false;
            for (int i = 0; i < N; i++) {
                if (cnt == i) continue;
                if (!arr[i].flag) continue;

                canHit = true;
                // cnt 계란으로 i 계란을 친다.
                arr[cnt].s -= arr[i].w;
                arr[i].s -= arr[cnt].w;
                if (arr[cnt].s <= 0) arr[cnt].flag = false;
                if (arr[i].s <= 0) arr[i].flag = false;

                dfs(cnt+1);

                arr[cnt].s += arr[i].w;
                arr[i].s += arr[cnt].w;
                if (arr[cnt].s > 0) arr[cnt].flag = true;
                if (arr[i].s > 0) arr[i].flag = true;
            }
            if (!canHit) dfs(cnt+1);
        }

    }

}

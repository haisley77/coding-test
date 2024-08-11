import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] res;
    static boolean[] selected;
    static int L, N;
    static String[] words;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        res = new int[L];
        selected = new boolean[N];
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        Arrays.sort(words);
        perm(0);
        if (!flag) System.out.println("NONE");

    }

    private static void perm(int cnt) {
        if (flag) return;
        if (cnt == L) {
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    if (words[res[i]].charAt(j) != words[res[j]].charAt(i)) {
                        return;
                    }
                }
            }
            flag = true;
            for (int i = 0; i < L; i++) {
                System.out.println(words[res[i]]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            res[cnt] = i;
            perm(cnt+1);
            selected[i] = false;
        }

    }
}

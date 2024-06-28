import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.MemoryType;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] alphabet;
    private static String[] words;
    private static char[] selected;
    private static int N, K, res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K >= 5) {
            selected = new char[K-5];
        }
        alphabet = new boolean[26];
        words = new String[N];
        
        alphabet['a' - 'a'] = true;
        alphabet['n' - 'a'] = true;
        alphabet['t' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['c' - 'a'] = true;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word.substring(4, word.length() - 4);
        }

        if (K < 5) res = 0;
        else combi(0, 0);

        System.out.println(res);
    }
    private static void combi(int cnt, int start) {
        if (cnt == K - 5) {
            res = Math.max(res, possible());
            return;
        }
        for (int i = start; i < alphabet.length; i++) {
            if (!alphabet[i]) {
                alphabet[i] = true;
                selected[cnt] = (char) (i + 'a');
                combi(cnt + 1, i + 1);
                alphabet[i] = false;
            }
        }
    }
    private static int possible() {
        int cnt = 0;
        for (String word : words) {
            boolean readable = true;
            for (int j = 0; j < word.length(); j++) {
                if (!alphabet[word.charAt(j) - 'a']) {
                    readable = false;
                    break;
                }
            }
            if (readable) cnt++;
        }
        return cnt;
    }

}

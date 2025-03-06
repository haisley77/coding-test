import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();

        int lSize = L.length();
        int rSize = R.length();

        if (lSize != rSize) {
            System.out.println(0);
        } else {
            int cnt = 0;
            for (int i = 0; i < rSize; i++) {
                if (L.charAt(i) != R.charAt(i)) {
                    break;  // 다른 숫자가 나오면 비교 중단
                }
                if (L.charAt(i) == '8') {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}

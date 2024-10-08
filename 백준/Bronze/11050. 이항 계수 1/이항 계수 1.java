import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (K == 0) {
            System.out.println(1);
        } else {
            int top = 1;
            for (int i = 0; i < K; i++) {
                top *= N;
                N--;
            }
            int bottom = 1;
            for (int i = K; i >= 1; i--) {
                bottom *= i;
            }
            System.out.println(top / bottom);
        }
    }
}

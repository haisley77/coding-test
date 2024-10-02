import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int r1 = b * d;
        int r2 = a * d + b * c;

        int m = r1 > r2 ? r2 : r1;
        int i = m;
        for (; i >= 1; i--) {
            if (r1 % i == 0 && r2 % i == 0) break;
        }

        System.out.println(r2 / i + " " + r1 / i);
    }
}

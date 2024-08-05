import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long res = combi(N, A) * combi(N-A,B);
        System.out.println(res);

    }

    private static long combi(int a, int b) {
        return fac(a) / (fac(b) * fac(a-b));
    }

    private static long fac(int n){
        if (n == 0) return 1L;
        return n * fac(n-1);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private static BigInteger A, B, res;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());
        res = B;
        checkCnt(A, BigInteger.ZERO);
        System.out.println(flag ? res.add(BigInteger.ONE) : -1);
    }

    private static void checkCnt(BigInteger cur, BigInteger cnt) {
        if (cur.equals(B)) {
            if (res.compareTo(cnt) > 0) {
                res = cnt;
            }
            flag = true;
            return;
        }
        if (cur.compareTo(B) > 0) {
            return;
        }
        checkCnt(cur.multiply(BigInteger.valueOf(2)), cnt.add(BigInteger.ONE));
        checkCnt(cur.multiply(BigInteger.TEN).add(BigInteger.ONE), cnt.add(BigInteger.ONE));
    }
}

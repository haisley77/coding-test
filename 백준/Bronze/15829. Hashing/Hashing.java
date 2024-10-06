import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();

        BigInteger H = new BigInteger("0");
        for (int i = 0; i < L; i++) {
            H = H.add(BigInteger.valueOf(s.charAt(i)-'a'+1).multiply(BigInteger.valueOf(31).pow(i)));
        }
        System.out.println(H.mod(BigInteger.valueOf(1234567891)));
    }
}

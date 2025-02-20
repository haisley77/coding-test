import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = 0;
        int T = 0;
        while (st.hasMoreTokens()) {
            S += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            T += Integer.parseInt(st.nextToken());
        }
        System.out.print(Math.max(S,T));
    }
}
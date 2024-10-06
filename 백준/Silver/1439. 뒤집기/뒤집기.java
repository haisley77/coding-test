import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cur = s.charAt(0) - '0';
        int s1 = 0;
        int s2 = 0;
        if (cur == 0) s1++;
        else s2++;

        for (int i = 1; i < s.length(); i++) {
            if (cur != s.charAt(i) -'0') {
                cur = s.charAt(i) - '0';
                if (cur == 0) s1++;
                else s2++;
            }
        }

        System.out.println(Integer.min(s1,s2));


    }
}

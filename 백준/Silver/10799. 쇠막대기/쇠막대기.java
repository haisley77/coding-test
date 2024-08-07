import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (s.charAt(i+1) == ')') {
                    res += cnt;
                    i++;
                } else {
                    cnt++;
                }
            }
            if (ch == ')') {
                cnt--;
                res++;
            }
        }
        System.out.println(res);
    }
}

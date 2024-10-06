import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (;;) {
            String s = br.readLine();
            if (s.equals("0")) break;
            int start = 0;
            int end = s.length()-1;
            boolean flag = true;
            while (end > start) {
                if (s.charAt(end) != s.charAt(start)) {
                    flag = false;
                    break;
                }
                end--;
                start++;
            }
            if (flag) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if ("ENTER".equals(command)) {
                set.clear();
                continue;
            }

            if (!set.contains(command)) {
                res++;
                set.add(command);
            }

        }
        System.out.print(res);
    }
}

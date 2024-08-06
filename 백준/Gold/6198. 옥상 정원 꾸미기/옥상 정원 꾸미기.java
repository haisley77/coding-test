import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long res = 0L;
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            long h = Long.parseLong(br.readLine());
            if (i == 0) stack.push(h);
            else {
                while (!stack.isEmpty() && (stack.peek() <= h)) {
                    stack.pop();
                }
                res += stack.size();
                stack.push(h);
            }
        }
        System.out.println(res);
    }
}

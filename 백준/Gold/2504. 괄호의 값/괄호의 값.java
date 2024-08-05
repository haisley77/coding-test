import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();

        int res = 0;
        int val = 1;
        for (int i = 0; i < line.length(); i++) {

            char ch = line.charAt(i);
            if (ch == '(') {
                val *= 2;
                stack.push(ch);
                continue;
            }
            if (ch == '[') {
                val *= 3;
                stack.push(ch);
                continue;
            }
            if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    res = 0;
                    break;
                }
                if (line.charAt(i-1) == '(') {
                    res += val;
                }
                stack.pop();
                val /= 2;
            }
            if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    res = 0;
                    break;
                }
                if (line.charAt(i-1) == '[') {
                    res += val;
                }
                stack.pop();
                val /= 3;
            }
        }

        if (!stack.isEmpty()) System.out.println(0);
        else System.out.println(res);

    }
}

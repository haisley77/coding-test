import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int res = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (stack.isEmpty()) stack.push(ch);
                else {
                    if (ch == stack.peek()) stack.pop();
                    else stack.push(ch);
                }
            }
            if (stack.isEmpty()) res++;
        }
        System.out.println(res);
    }
}

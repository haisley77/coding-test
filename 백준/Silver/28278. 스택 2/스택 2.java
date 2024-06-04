import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<String> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("1")) {
                stack.push(command[1]);
                continue;
            }
            if (command[0].equals("2")){
                if (stack.empty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
                continue;
            }
            if (command[0].equals("3")){
                sb.append(stack.size()).append("\n");
                continue;
            }
            if (command[0].equals("4")){
                if (stack.empty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
                continue;
            }
            if (command[0].equals("5")){
                if (stack.empty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
                continue;
            }
        }
        System.out.println(sb);
    }
}

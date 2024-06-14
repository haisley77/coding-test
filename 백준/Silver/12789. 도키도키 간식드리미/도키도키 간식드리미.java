import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," " );
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N-1; i >= 0; i--) {
            s1.push(arr[i]);
        }

        int cur = 1;
        String res = "Nice";
        while (!s1.isEmpty()) {
            if (cur == s1.peek()) {
                s1.pop();
                cur++;
            } else {
                if (s2.isEmpty()) {
                    s2.push(s1.pop());
                } else {
                    if (cur == s2.peek()) {
                        s2.pop();
                        cur++;
                    } else {
                        s2.push(s1.pop());
                    }
                }
            }
        }
        while (!s2.isEmpty()) {
            if (s2.pop() != cur++) {
                res = "Sad";
                break;
            }
        }
        System.out.println(res);
    }
}

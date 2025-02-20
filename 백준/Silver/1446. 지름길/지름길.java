import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int a;
        int b;
        int w;
        Node next;
        Node(int a, int b, int w, Node next) {
            this.a = a;
            this.b = b;
            this.w = w;
            this.next = next;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.w, node.w);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dp = new int[D+1]; // 0 ~ D
        Arrays.fill(dp, Integer.MAX_VALUE);
        Node[] path = new Node[10001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            path[a] = new Node(a,b,w,path[a]);
        }

        dp[0] = 0;
        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                if (dp[i] == Integer.MAX_VALUE) {
                    dp[i] = dp[i-1] + 1;
                } else {
                    dp[i] = Integer.min(dp[i], dp[i - 1] + 1);
                }
            }
            for (Node cur = path[i]; cur != null; cur = cur.next) {
                if (cur.b <= D) {
                    dp[cur.b] = Integer.min(dp[cur.b], dp[i] + cur.w);
                }
            }
        }
        System.out.println(dp[D]);
    }


}

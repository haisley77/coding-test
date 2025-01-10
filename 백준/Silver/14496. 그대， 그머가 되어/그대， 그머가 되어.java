import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int v;
        Node next;
        Node(int v, Node next) {
            this.v = v;
            this.next = next;
        }
    }
    static int N, M, res = Integer.MAX_VALUE;
    static Node[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Node[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1] = new Node(v2, arr[v1]);
            arr[v2] = new Node(v1, arr[v2]);
        }

        bfs(a,b);
        bfs(b,a);

        if (res == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(res);

    }

    static void bfs(int a ,int b) {
        int[] visited = new int[N+1];
        Arrays.fill(visited, -1);
        Queue<Integer> q = new LinkedList<>();
        visited[a] = 0;
        q.offer(a);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Node node = arr[cur]; node != null; node = node.next) {
                if (visited[node.v] >= 0) continue;
                visited[node.v] = visited[cur] + 1;
                q.offer(node.v);
            }
        }

        if (visited[b] == -1) return;

        if (res > visited[b]) res = visited[b];

    }
}

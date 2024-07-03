import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Node {
        int cur;
        Node next;
        Node(int cur, Node next) {
            this.cur = cur;
            this.next = next;
        }
    }

    private static int N, root, leaf;
    private static Node[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new Node[N];
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) root = i;
        }

        for (int i = 0; i < N; i++) {
            if (i == root) continue;
            graph[parent[i]] = new Node(i, graph[parent[i]]);
        }

        int num = Integer.parseInt(br.readLine());

        if (num == root){
            System.out.println(0);
        } else {
            bfs(num);
            System.out.println(leaf);
        }

    }

    private static void bfs(int num) {
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        visited[root] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            boolean flag = true;
            for (Node node = graph[cur]; node != null; node = node.next) {
                if (visited[node.cur]) continue;
                if (node.cur == num) continue;
                visited[node.cur] = true;
                q.offer(node.cur);
                flag = false;
            }

            if (flag) leaf++;
        }

    }

}

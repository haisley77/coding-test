import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        char value;
        Node left;
        Node right;
        Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] graph = new Node[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char cur = s.charAt(0);
            char left = s.charAt(2);
            char right = s.charAt(4);

            if (graph[cur-'A'] == null) {
                graph[cur-'A'] = new Node(cur);
             }

            if (left != '.') {
                graph[left-'A'] = new Node(left);
                graph[cur-'A'].left = graph[left-'A'];
            }

            if (right != '.') {
                graph[right-'A'] = new Node(right);
                graph[cur-'A'].right = graph[right-'A'];
            }

        }
        preorder(graph[0], graph);
        sb.append("\n");
        inorder(graph[0], graph);
        sb.append("\n");
        postorder(graph[0], graph);
        System.out.println(sb);
    }
    private static void preorder(Node cur, Node[] graph) {
        if (cur == null) return;

        sb.append(cur.value);
        preorder(cur.left, graph);
        preorder(cur.right, graph);
    }
    private static void inorder(Node cur, Node[] graph) {
        if (cur == null) return;

        inorder(cur.left, graph);
        sb.append(cur.value);
        inorder(cur.right, graph);
    }
    private static void postorder(Node cur, Node[] graph) {
        if (cur == null) return;

        postorder(cur.left, graph);
        postorder(cur.right, graph);
        sb.append(cur.value);
    }
}

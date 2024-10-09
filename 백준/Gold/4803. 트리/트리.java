import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int a;
        int b;
        Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            parent = new int[N+1];
            for (int i = 1; i <= N; i++) parent[i] = i;

            Edge[] graph = new Edge[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[i] = new Edge(a,b);
            }

            for (int i = 0; i < M; i++) {
                Edge cur = graph[i];

                if (find(cur.a) == find(cur.b)) {
                    union(cur.a, 0);
                    union(cur.b, 0);
                    continue;
                }

                union(cur.a,cur.b);
            }

            boolean[] checked = new boolean[N+1];
            int total = 0;
            for (int i = 1; i <= N; i++) {
                int set = find(i);
                if (set == 0) continue;
                if (checked[set]) continue;
                checked[set] = true;
                total++;
            }


            sb.append("Case ").append(t).append(": ");
            if (total > 1) {
                sb.append("A forest of ").append(total).append(" trees.").append("\n");
            } else if (total == 1) {
                sb.append("There is one tree.").append("\n");
            } else {
                sb.append("No trees.").append("\n");
            }
        }
        System.out.println(sb);

    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]); // 경로 압축
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        if (a > b) parent[a] = b;
    }


}

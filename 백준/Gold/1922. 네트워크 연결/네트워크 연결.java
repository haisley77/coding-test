import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class Main {
    static int res, N;
    static int[] parent;
    static ArrayList<Edge> graph;
    static class Edge {
        int a;
        int b;
        int w;
        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Edge(a,b,c));
        }
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        Collections.sort(graph, new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.w - e2.w;
            }
        });
        kruskal();
        System.out.println(res);
    }

    private static void kruskal() {
        for (int i = 0; i < graph.size(); i++) {
            Edge edge = graph.get(i);
            if (find(edge.a) == find(edge.b)) continue;

            res += edge.w;
            union(edge.a, edge.b);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int v) {
        if (parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }
}

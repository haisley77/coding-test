import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<Edge> graph;
    private static int[] parent;
    private static class Edge {
        int x;
        int y;
        int z;
        Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;

            graph = new ArrayList<>();
            parent = new int[m];

            int total = 0;

            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                graph.add(new Edge(x,y,z));
                total += z;
            }
            Collections.sort(graph, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.z - o2.z;
                }
            });
            int res = kruskal();
            sb.append(total - res).append("\n");
        }

        System.out.print(sb);
    }

    private static int kruskal(){
        int res = 0;
        for (int i = 0; i < graph.size(); i++) {
            Edge edge = graph.get(i);
            if (find(edge.x) == find(edge.y)) continue;
            union(edge.x, edge.y);
            res += edge.z;
        }
        return res;
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        }
        if (a > b) {
            parent[a] = b;
        }
    }

    private static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}

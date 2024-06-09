import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int a;
        int b;
        int c;
        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static ArrayList<Edge> graph;
    static int[] parent;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.add(new Edge(a,b,i));
        }

        for (int i = 0; i < graph.size(); i++){
            Edge edge = graph.get(i);
            if (find(edge.a) == find(edge.b)) {
                res = edge.c;
                break;
            }
            union(edge.a, edge.b);
        }
        System.out.println(res);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        if (a > b) parent[a] = b;
    }
    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }


}

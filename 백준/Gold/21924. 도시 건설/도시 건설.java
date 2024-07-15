import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        Long w;
        Edge(int a, int b, Long w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return Long.compare(this.w, e.w);
        }
    }

    static int[] parent;
    static ArrayList<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Long total = 0L;
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Long w = Long.parseLong(st.nextToken());
            total += w;
            list.add(new Edge(a,b,w));
        }

        Collections.sort(list);

        Long res = 0L;
        int edgeCount = 0;
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            if (find(edge.a) == find(edge.b)) continue;
            union(edge.a, edge.b);
            res += edge.w;
            edgeCount++;
        }

        if (edgeCount == N-1) System.out.println(total - res);
        else System.out.println(-1);

    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        }
        if (a > b) {
            parent[a] = b;
        }
    }
}

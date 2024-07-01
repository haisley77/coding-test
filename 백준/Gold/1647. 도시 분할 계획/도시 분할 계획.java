import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;
    private static int N, res;
    private static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int c;
        Edge(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.c, o.c);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Edge> list = new ArrayList<>();
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a,b,c));
        }
        Collections.sort(list);

        mst(list);

        System.out.println(res);
    }
    private static void mst(ArrayList<Edge> list) {
        int cnt = 0;
        int cost = 0;
        int maxCost = 0;
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            if (find(edge.a) == find(edge.b)) continue;
            union(edge.a, edge.b);
            cost += edge.c;
            maxCost = edge.c;
            cnt += 1;
            if (cnt == N-1) break;
        }
        res = cost - maxCost;
    }
    private static int find(int a) {
        if (parent[a] == a) return a;
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
